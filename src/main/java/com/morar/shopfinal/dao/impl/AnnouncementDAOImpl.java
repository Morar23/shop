package com.morar.shopfinal.dao.impl;

import com.morar.shopfinal.dao.AnnouncementDAO;
import com.morar.shopfinal.dto.AnnouncementDTO;
import com.morar.shopfinal.entity.Announcement;
import com.morar.shopfinal.entity.Category;
import com.morar.shopfinal.entity.User;
import com.morar.shopfinal.repository.AnnouncementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class AnnouncementDAOImpl implements AnnouncementDAO {

    private final AnnouncementRepository announcementRepository;

    @Autowired
    public AnnouncementDAOImpl(AnnouncementRepository announcementRepository) {this.announcementRepository = announcementRepository;}

    public List<Announcement> getAllAnnouncements(){return  announcementRepository.findAll();}

    public Announcement getAnnouncementByName(String name){return  announcementRepository.findByName(name);}

    @Override
    public void updateAnnouncement(AnnouncementDTO announcementDTO, Category category) {
        if (announcementDTO != null){
            if (announcementRepository.existsById(announcementDTO.getId())){
                Announcement announcement = announcementRepository.getById(announcementDTO.getId());
                announcement.setName(announcementDTO.getName());
                announcement.setDescription(announcementDTO.getDescription());
                announcement.setPrice(announcementDTO.getPrice());
                announcement.setCreated_in(announcementDTO.getCreatedIn());
                if (category != null){
                    announcement.setCategory(category);
                }
                announcementRepository.saveAndFlush(announcement);
            }
        }
    }

    public void saveAnnouncement(AnnouncementDTO announcementDTO, User author, Category category)
    {
        Announcement announcement = new Announcement();
        announcement.setName(announcementDTO.getName());
        announcement.setDescription(announcementDTO.getDescription());
        announcement.setPrice(announcementDTO.getPrice());
        announcement.setCreated_in(announcementDTO.getCreatedIn());
        announcement.setAddress(announcementDTO.getAddress());
        announcement.setAuthor(author);
        announcement.setCategory(category);

        announcementRepository.saveAndFlush(announcement);
    }

    public boolean deleteAnnouncement(Long announcementId){
        if (announcementId != 0){
            if (announcementRepository.existsById(announcementId)){
                return announcementRepository.deleteAllById(announcementId) > 0;
            }
        }
        return false;
    }

}
