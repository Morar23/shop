package com.morar.shopfinal.dao;

import com.morar.shopfinal.dto.AnnouncementDTO;
import com.morar.shopfinal.entity.Announcement;
import com.morar.shopfinal.entity.Category;
import com.morar.shopfinal.entity.User;

import java.util.List;

public interface AnnouncementDAO {
    List<Announcement> getAllAnnouncement();

    Announcement getAnnouncementByName(String name);

    void saveAnnouncement(AnnouncementDTO announcementDTO, User author, Category category);

    boolean deleteAnnouncement(AnnouncementDTO announcementDTO);
}
