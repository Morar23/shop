package com.morar.shopfinal.service;

import com.morar.shopfinal.dto.AnnouncementDTO;
import com.morar.shopfinal.entity.Announcement;

import java.util.List;

public interface AnnouncementService {
    List<AnnouncementDTO> getAllAnnouncements();

    AnnouncementDTO getAnnouncementByName(String name);

    AnnouncementDTO getAnnouncementById(Long id);

    boolean deleteAnnouncement(Long announcementId);

    void saveAnnouncement(AnnouncementDTO announcementDTO);

    void updateAnnouncement(AnnouncementDTO announcementDTO);
}
