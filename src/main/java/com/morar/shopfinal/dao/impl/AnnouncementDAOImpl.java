package com.morar.shopfinal.dao.impl;

import com.morar.shopfinal.dao.AnnouncementDAO;
import com.morar.shopfinal.dto.AnnouncementDTO;
import com.morar.shopfinal.entity.Announcement;
import com.morar.shopfinal.entity.Category;
import com.morar.shopfinal.entity.User;
import com.morar.shopfinal.exception.impl.AnnouncementNotFoundException;
import com.morar.shopfinal.repository.AnnouncementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Component
@Transactional
public class AnnouncementDAOImpl implements AnnouncementDAO {

    private final AnnouncementRepository announcementRepository;

    @Autowired
    public AnnouncementDAOImpl(AnnouncementRepository announcementRepository) {
        this.announcementRepository = announcementRepository;
    }

    @Override
    public List<Announcement> getAllAnnouncements() {
        return announcementRepository.findAll();
    }

    @Override
    public Announcement getAnnouncementById(Long id) throws AnnouncementNotFoundException {
        return announcementRepository.findById(id).orElseThrow(AnnouncementNotFoundException::new);
    }

    @Override
    public Announcement saveAnnouncement(@NonNull AnnouncementDTO announcementDTO, @NonNull User author, @NonNull Category category) {
        Announcement announcement = new Announcement();
        announcement.setName(announcementDTO.getName());
        announcement.setDescription(announcementDTO.getDescription());
        announcement.setPrice(announcementDTO.getPrice());
        announcement.setCreatedIn(announcementDTO.getCreatedIn());
        announcement.setAddress(announcementDTO.getAddress());
        announcement.setAuthor(author);
        announcement.setCategory(category);
        announcementRepository.saveAndFlush(announcement);
        return announcement;
    }

    @Override
    public Announcement updateAnnouncement(@NonNull AnnouncementDTO announcementDTO, @NonNull Category category) throws AnnouncementNotFoundException {
        Announcement announcement = announcementRepository.findById(announcementDTO.getId()).orElseThrow(AnnouncementNotFoundException::new);
        announcement.setName(announcementDTO.getName());
        announcement.setDescription(announcementDTO.getDescription());
        announcement.setPrice(announcementDTO.getPrice());
        announcement.setCreatedIn(announcementDTO.getCreatedIn());
        announcement.setCategory(category);
        announcementRepository.saveAndFlush(announcement);
        return announcement;
    }

    @Override
    public void deleteAnnouncement(Long id) throws AnnouncementNotFoundException {
        if (announcementRepository.deleteAllById(id) == 0) {
            throw new AnnouncementNotFoundException();
        }
    }

    @Override
    public void deleteAllAnnouncementByAuthorId(Long userId) {
        //TODO
    }
}
