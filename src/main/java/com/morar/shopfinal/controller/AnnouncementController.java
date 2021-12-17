package com.morar.shopfinal.controller;

import com.morar.shopfinal.dao.impl.AnnouncementDAOImpl;
import com.morar.shopfinal.entity.Announcement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AnnouncementController {
    private final AnnouncementDAOImpl announcementDAO;

    @Autowired
    public AnnouncementController(AnnouncementDAOImpl announcementDAO) {
        this.announcementDAO = announcementDAO;
    }

    @GetMapping("/announcementa")
    public List<Announcement> getAnnouncement(){
        return announcementDAO.getAllAnnouncement();
    }

}
