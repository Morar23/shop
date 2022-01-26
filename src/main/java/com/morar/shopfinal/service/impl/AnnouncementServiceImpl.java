package com.morar.shopfinal.service.impl;

import com.morar.shopfinal.dao.AnnouncementDAO;
import com.morar.shopfinal.dao.CategoryDAO;
import com.morar.shopfinal.dao.impl.UserDAO;
import com.morar.shopfinal.dto.AnnouncementDTO;
import com.morar.shopfinal.entity.Announcement;
import com.morar.shopfinal.entity.Category;
import com.morar.shopfinal.entity.User;
import com.morar.shopfinal.exception.AnnouncementNotFoundException;
import com.morar.shopfinal.exception.CategoryNotFoundException;
import com.morar.shopfinal.service.AnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
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
        return announcements.stream().map(el -> new AnnouncementDTO(
                el.getId(),
                el.getName(),
                el.getDescription(),
                el.getPrice(),
                el.getAddress(),
                el.getCreated_in(),
                el.getCategory().getId(),
                el.getAuthor().getId()
        )).collect(Collectors.toList());
    }

    @Override
    public AnnouncementDTO getAnnouncementById(Long id) throws AnnouncementNotFoundException {
        Announcement announcement = announcementDAO.getAnnouncementById(id);
        return new AnnouncementDTO(
                announcement.getId(),
                announcement.getName(),
                announcement.getDescription(),
                announcement.getPrice(),
                announcement.getAddress(),
                announcement.getCreated_in(),
                announcement.getCategory().getId(),
                announcement.getAuthor().getId()
        );
    }

    public void saveAnnouncement(@NonNull AnnouncementDTO announcementDTO) throws CategoryNotFoundException {
        Category category = categoryDAO.getCategoryById(announcementDTO.getCategoryId());
        User user = userDAO.getUserById(1L);
        announcementDAO.saveAnnouncement(announcementDTO, user, category);
    }

    @Override
    public void updateAnnouncement(@NonNull AnnouncementDTO announcementDTO) throws AnnouncementNotFoundException, CategoryNotFoundException {
        Category category = categoryDAO.getCategoryById(announcementDTO.getCategoryId());
        announcementDAO.updateAnnouncement(announcementDTO, category);
    }

    @Override
    public void deleteAnnouncement(Long id) throws AnnouncementNotFoundException {
        announcementDAO.deleteAnnouncement(id);
    }
}
