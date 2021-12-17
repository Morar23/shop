package com.morar.shopfinal.service.impl;

import com.morar.shopfinal.dao.AnnouncementDAO;
import com.morar.shopfinal.dao.CategoryDAO;
import com.morar.shopfinal.dto.AnnouncementDTO;
import com.morar.shopfinal.entity.Category;
import com.morar.shopfinal.entity.User;
import com.morar.shopfinal.service.AnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnnouncementServiceImpl implements AnnouncementService {

    private final AnnouncementDAO announcementDAO;

    private final CategoryDAO categoryDAO;

    @Autowired
    public AnnouncementServiceImpl(AnnouncementDAO announcementDAO, CategoryDAO categoryDAO) {
        this.announcementDAO = announcementDAO;
        this.categoryDAO = categoryDAO;
    }

    public void saveAnnouncement(AnnouncementDTO announcementDTO) {
        Category category = categoryDAO.getCategoryById(announcementDTO.getCategoryId());
        User user = new User();
        announcementDAO.saveAnnouncement(announcementDTO, user, category);
    }
}
