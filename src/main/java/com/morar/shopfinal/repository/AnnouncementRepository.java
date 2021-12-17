package com.morar.shopfinal.repository;

import com.morar.shopfinal.entity.Announcement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnnouncementRepository extends JpaRepository<Announcement, Long> {

    Announcement findByName(String name);

    boolean existsAnnouncementById(long id);

    long deleteAllById(long id);
}
