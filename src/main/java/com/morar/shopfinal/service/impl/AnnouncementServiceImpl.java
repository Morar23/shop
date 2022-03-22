package com.morar.shopfinal.service.impl;

import com.morar.shopfinal.dao.AnnouncementDAO;
import com.morar.shopfinal.dao.CategoryDAO;
import com.morar.shopfinal.dao.UserDAO;
import com.morar.shopfinal.dto.AnnouncementDTO;
import com.morar.shopfinal.entity.Announcement;
import com.morar.shopfinal.entity.Category;
import com.morar.shopfinal.entity.User;
import com.morar.shopfinal.exception.impl.AnnouncementNotFoundException;
import com.morar.shopfinal.exception.impl.CategoryNotFoundException;
import com.morar.shopfinal.exception.impl.UserNotFoundException;
import com.morar.shopfinal.service.AnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnnouncementServiceImpl implements AnnouncementService {

    private final AnnouncementDAO announcementDAO;

    private final CategoryDAO categoryDAO;

    private final UserDAO userDAO;

    @Autowired
    public AnnouncementServiceImpl(AnnouncementDAO announcementDAO, CategoryDAO categoryDAO, UserDAO userDAO) {
        this.announcementDAO = announcementDAO;
        this.categoryDAO = categoryDAO;
        this.userDAO = userDAO;
    }

    @Override
    public List<AnnouncementDTO> getAllAnnouncements() {
        List<Announcement> announcements = announcementDAO.getAllAnnouncements();
        return announcements.stream().map(this::transformAnnouncementToAnnouncementDTO).collect(Collectors.toList());
    }

    @Override
    public AnnouncementDTO getAnnouncementById(Long id) throws AnnouncementNotFoundException {
        Announcement announcement = announcementDAO.getAnnouncementById(id);
        return transformAnnouncementToAnnouncementDTO(announcement);
    }

    public AnnouncementDTO saveAnnouncement(@NonNull AnnouncementDTO announcementDTO) throws CategoryNotFoundException, UserNotFoundException {
        Category category = categoryDAO.getCategoryById(announcementDTO.getCategoryId());
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        String userEmail;

        if (principal instanceof UserDetails) {
            userEmail = ((UserDetails)principal).getUsername();
        } else {
            userEmail = principal.toString();
        }

        User user = userDAO.getUserByEmail(userEmail);
        return transformAnnouncementToAnnouncementDTO(announcementDAO.saveAnnouncement(announcementDTO, user, category));
    }

    @Override
    public AnnouncementDTO updateAnnouncement(@NonNull AnnouncementDTO announcementDTO) throws AnnouncementNotFoundException, CategoryNotFoundException {
        Category category = categoryDAO.getCategoryById(announcementDTO.getCategoryId());
        return transformAnnouncementToAnnouncementDTO(announcementDAO.updateAnnouncement(announcementDTO, category));
    }

    @Override
    public void deleteAnnouncement(Long id) throws AnnouncementNotFoundException {
        announcementDAO.deleteAnnouncement(id);
    }

    @Override
    public void deleteAllAnnouncementsByAuthorId(Long id){
        announcementDAO.deleteAllAnnouncementByAuthorId(id);
    }

    private AnnouncementDTO transformAnnouncementToAnnouncementDTO(Announcement announcement) {
        return new AnnouncementDTO(
                announcement.getId(),
                announcement.getName(),
                announcement.getDescription(),
                announcement.getPrice(),
                announcement.getAddress(),
                announcement.getCreatedIn(),
                announcement.getCategory().getId(),
                announcement.getAuthor().getId()
        );
    }
}
