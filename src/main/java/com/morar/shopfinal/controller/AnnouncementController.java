package com.morar.shopfinal.controller;

import com.morar.shopfinal.dto.AnnouncementDTO;
import com.morar.shopfinal.exception.impl.AnnouncementNotFoundException;
import com.morar.shopfinal.exception.impl.CategoryNotFoundException;
import com.morar.shopfinal.exception.impl.UserNotFoundException;
import com.morar.shopfinal.service.AnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AnnouncementController {
    private final AnnouncementService announcementService;

    @Autowired
    public AnnouncementController(AnnouncementService announcementService) {
        this.announcementService = announcementService;
    }

    @GetMapping("/announcements")
    public ResponseEntity<List<AnnouncementDTO>> getAnnouncements() {
        List<AnnouncementDTO> announcements = announcementService.getAllAnnouncements();
        return new ResponseEntity<>(announcements, HttpStatus.OK);
    }

    @GetMapping("/announcement/{id}")
    public ResponseEntity<AnnouncementDTO> getAnnouncement(@PathVariable Long id) throws AnnouncementNotFoundException {
        AnnouncementDTO announcement = announcementService.getAnnouncementById(id);
        return new ResponseEntity<>(announcement, HttpStatus.OK);
    }

    @PostMapping(value = "/announcement", consumes = "application/json")
    public ResponseEntity<AnnouncementDTO> saveAnnouncement(@RequestBody AnnouncementDTO announcementDTO) throws UserNotFoundException, CategoryNotFoundException {
        AnnouncementDTO announcement = announcementService.saveAnnouncement(announcementDTO);
        return new ResponseEntity<>(announcement, HttpStatus.OK);
    }

    @PutMapping(value = "/announcement", consumes = "application/json")
    public ResponseEntity<AnnouncementDTO> updateAnnouncement(@RequestBody AnnouncementDTO announcementDTO) throws AnnouncementNotFoundException, CategoryNotFoundException {
        AnnouncementDTO announcement = announcementService.updateAnnouncement(announcementDTO);
        return new ResponseEntity<>(announcement, HttpStatus.OK);
    }

    @DeleteMapping(value = "/announcement/{id}")
    public ResponseEntity<Void> deleteAnnouncement(@PathVariable long id) throws AnnouncementNotFoundException {
        announcementService.deleteAnnouncement(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
