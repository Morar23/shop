package com.morar.shopfinal.repository;

import com.morar.shopfinal.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByName(String name);

    User findByMail(String mail);

    boolean existsUsersByMail(String mail);

    long deleteByMail(String mail);
}
