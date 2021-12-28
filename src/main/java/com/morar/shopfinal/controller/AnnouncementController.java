package com.morar.shopfinal.controller;

import com.morar.shopfinal.dto.AnnouncementDTO;
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
    public List<AnnouncementDTO> getAnnouncements(){
        return announcementService.getAllAnnouncements();
    }

    @GetMapping("/announcement/{id}")
    public ResponseEntity<AnnouncementDTO> getAnnouncement(@PathVariable Long id){
        AnnouncementDTO announcement = announcementService.getAnnouncementById(id);
        return new ResponseEntity<>(announcement, HttpStatus.OK);
    }

    @PutMapping(value = "/announcement", consumes = "application/json")
    public ResponseEntity<Void> updateAnnouncement(@RequestBody AnnouncementDTO announcementDTO){
        announcementService.updateAnnouncement(announcementDTO);
        return ResponseEntity.accepted().build();
    }

    @DeleteMapping(value = "/announcement/{id}")
    public ResponseEntity<Void> deleteAnnouncement(@PathVariable long id){
        announcementService.deleteAnnouncement(id);
        return ResponseEntity.accepted().build();
    }

    @PostMapping(value = "/announcement", consumes = "application/json")
    public ResponseEntity<Void> saveAnnouncement(@RequestBody AnnouncementDTO announcementDTO) throws URISyntaxException {
        announcementService.saveAnnouncement(announcementDTO);
        URI announcementURI = new URI("/announcement");
        return ResponseEntity.created(announcementURI).build();
    }
}
