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

    public List<Announcement> getAllAnnouncement(){return  announcementRepository.findAll();}

    public Announcement getAnnouncementByName(String name){return  announcementRepository.findByName(name);}

    public void saveAnnouncement(AnnouncementDTO announcementDTO, User author, Category category)
    {
        Announcement announcement = new Announcement();
        announcement.setName(announcementDTO.getName());
        announcement.setDescription(announcementDTO.getDescription());
        announcement.setPrice(announcementDTO.getPrice());
        announcement.setCreated_in(announcementDTO.getCreated_in());
        announcement.setAddress(announcementDTO.getAddress());
        announcement.setAuthor(author);
        announcement.setCategory(category);

        announcementRepository.saveAndFlush(announcement);
    }

    public boolean deleteAnnouncement(AnnouncementDTO announcementDTO){
        if (announcementDTO != null && announcementDTO.getId() != 0){
            if (announcementRepository.existsById(announcementDTO.getId())){
                return announcementRepository.deleteAllById(announcementDTO.getId()) > 0;
            }
        }
        return false;
    }

}
