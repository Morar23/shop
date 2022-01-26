package com.morar.shopfinal.controller;

import com.morar.shopfinal.dto.AnnouncementDTO;
import com.morar.shopfinal.exception.AnnouncementNotFoundException;
import com.morar.shopfinal.exception.CategoryNotFoundException;
import com.morar.shopfinal.service.AnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class AnnouncementController {
    private final AnnouncementService announcementService;

    @Autowired
    public AnnouncementController(AnnouncementService announcementService) {
        this.announcementService = announcementService;
    }

    @GetMapping("/announcements")
    public ResponseEntity<List<AnnouncementDTO>> getAnnouncements(){
        List<AnnouncementDTO> announcements = announcementService.getAllAnnouncements();
        return new ResponseEntity<>(announcements, HttpStatus.OK);
    }

    @GetMapping("/announcement/{id}")
    public ResponseEntity<AnnouncementDTO> getAnnouncement(@PathVariable Long id){
        try {
            AnnouncementDTO announcement = announcementService.getAnnouncementById(id);
            return new ResponseEntity<>(announcement, HttpStatus.OK);
        } catch (AnnouncementNotFoundException e) {
            e.printStackTrace();
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping(value = "/announcement", consumes = "application/json")
    public ResponseEntity<Void> saveAnnouncement(@RequestBody AnnouncementDTO announcementDTO) {
        try {
            announcementService.saveAnnouncement(announcementDTO);
            URI announcementURI = new URI("/announcement");
            return ResponseEntity.created(announcementURI).build();
        } catch (CategoryNotFoundException e) {
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        } catch (URISyntaxException e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    @PutMapping(value = "/announcement", consumes = "application/json")
    public ResponseEntity<Void> updateAnnouncement(@RequestBody AnnouncementDTO announcementDTO){
        try {
            announcementService.updateAnnouncement(announcementDTO);
            return ResponseEntity.accepted().build();
        } catch (AnnouncementNotFoundException | CategoryNotFoundException e) {
            e.printStackTrace();
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping(value = "/announcement/{id}")
    public ResponseEntity<Void> deleteAnnouncement(@PathVariable long id){
        try {
            announcementService.deleteAnnouncement(id);
            return ResponseEntity.accepted().build();
        } catch (AnnouncementNotFoundException e) {
            e.printStackTrace();
        }
        return ResponseEntity.notFound().build();
    }
}
