package com.morar.shopfinal.service;

import com.morar.shopfinal.dto.AnnouncementDTO;
import com.morar.shopfinal.exception.AnnouncementNotFoundException;
import com.morar.shopfinal.exception.CategoryNotFoundException;
import com.morar.shopfinal.exception.UserNotFoundException;
import org.springframework.lang.NonNull;

import java.util.List;

public interface AnnouncementService {
    List<AnnouncementDTO> getAllAnnouncements();

    AnnouncementDTO getAnnouncementById(Long id) throws AnnouncementNotFoundException;

    AnnouncementDTO saveAnnouncement(@NonNull AnnouncementDTO announcementDTO) throws CategoryNotFoundException, UserNotFoundException;

    AnnouncementDTO updateAnnouncement(@NonNull AnnouncementDTO announcementDTO) throws AnnouncementNotFoundException, CategoryNotFoundException;

    void deleteAnnouncement(Long id) throws AnnouncementNotFoundException;
}
