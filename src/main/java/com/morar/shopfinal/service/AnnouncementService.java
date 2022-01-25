package com.morar.shopfinal.service;

import com.morar.shopfinal.dto.AnnouncementDTO;
import com.morar.shopfinal.entity.Announcement;
import com.morar.shopfinal.exception.AnnouncementNotFoundException;
import org.springframework.lang.NonNull;

import java.util.List;

public interface AnnouncementService {
    List<AnnouncementDTO> getAllAnnouncements();

    AnnouncementDTO getAnnouncementById(Long id) throws AnnouncementNotFoundException;

    void saveAnnouncement(@NonNull AnnouncementDTO announcementDTO);

    void updateAnnouncement(@NonNull AnnouncementDTO announcementDTO) throws AnnouncementNotFoundException;

    void deleteAnnouncement(Long announcementId) throws AnnouncementNotFoundException;
}
