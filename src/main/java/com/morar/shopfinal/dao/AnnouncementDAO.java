package com.morar.shopfinal.dao;

import com.morar.shopfinal.dto.AnnouncementDTO;
import com.morar.shopfinal.entity.Announcement;
import com.morar.shopfinal.entity.Category;
import com.morar.shopfinal.entity.User;
import com.morar.shopfinal.exception.AnnouncementNotFoundException;
import org.springframework.lang.NonNull;

import java.util.List;

public interface AnnouncementDAO {
    List<Announcement> getAllAnnouncements();

    Announcement getAnnouncementById(Long id) throws AnnouncementNotFoundException;

    Announcement saveAnnouncement(@NonNull AnnouncementDTO announcementDTO, @NonNull User author, @NonNull Category category);

    Announcement updateAnnouncement(@NonNull AnnouncementDTO announcementDTO, @NonNull Category category) throws AnnouncementNotFoundException;

    void deleteAnnouncement(Long id) throws AnnouncementNotFoundException;

    void deleteAllAnnouncementByAuthorId(Long userId);
}
