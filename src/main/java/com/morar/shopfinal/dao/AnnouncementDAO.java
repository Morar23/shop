package com.morar.shopfinal.dao;

import com.morar.shopfinal.dto.AnnouncementDTO;
import com.morar.shopfinal.entity.Announcement;
import com.morar.shopfinal.entity.Category;
import com.morar.shopfinal.entity.User;

import java.util.List;

public interface AnnouncementDAO {
    List<Announcement> getAllAnnouncements();

    Announcement getAnnouncementByName(String name);

    Announcement getAnnouncementById(Long id);

    void updateAnnouncement(AnnouncementDTO announcementDTO, Category category);

    boolean deleteAnnouncement(Long announcementId);

    void saveAnnouncement(AnnouncementDTO announcementDTO, User author, Category category);
}
