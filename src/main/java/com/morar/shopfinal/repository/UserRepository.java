package com.morar.shopfinal.repository;

import com.morar.shopfinal.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByName(String name);
    User findByMail(String mail);
}
