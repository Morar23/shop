package com.morar.shopfinal.service.impl;

import com.morar.shopfinal.dao.AnnouncementDAO;
import com.morar.shopfinal.dao.CategoryDAO;
import com.morar.shopfinal.dao.impl.UserDAO;
import com.morar.shopfinal.dto.AnnouncementDTO;
import com.morar.shopfinal.entity.Announcement;
import com.morar.shopfinal.entity.Category;
import com.morar.shopfinal.entity.User;
import com.morar.shopfinal.service.AnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

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

    public void saveAnnouncement(AnnouncementDTO announcementDTO) {
        Category category = categoryDAO.getCategoryById(announcementDTO.getCategoryId());
        User user = userDAO.getUserById(1L);
        announcementDAO.saveAnnouncement(announcementDTO, user, category);
    }

    @Override
    public void updateAnnouncement(AnnouncementDTO announcementDTO) {
        Category category = null;
        if (announcementDTO.getCategoryId() > 0){
            category = categoryDAO.getCategoryById(announcementDTO.getCategoryId());
        }
        announcementDAO.updateAnnouncement(announcementDTO, category);
    }

    @Override
    public List<AnnouncementDTO> getAllAnnouncements() {
        List<Announcement> announcements = announcementDAO.getAllAnnouncements();
        List<AnnouncementDTO> announcementDTOS = new LinkedList<>();
        for (Announcement el : announcements){
            AnnouncementDTO announcementDTO = new AnnouncementDTO(
                    el.getId(),
                    el.getName(),
                    el.getDescription(),
                    el.getPrice(),
                    el.getAddress(),
                    el.getCreated_in(),
                    el.getCategory().getId(),
                    el.getAuthor().getId()
            );
            announcementDTOS.add(announcementDTO);
        }
        return announcementDTOS;
    }

    @Override
    public AnnouncementDTO getAnnouncementByName(String name) {
        Announcement announcement = announcementDAO.getAnnouncementByName(name);
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

    @Override
    public AnnouncementDTO getAnnouncementById(Long id) {
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

    @Override
    public boolean deleteAnnouncement(Long announcementId) {
        return announcementDAO.deleteAnnouncement(announcementId);
    }
}