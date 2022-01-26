package com.morar.shopfinal.repository;

import com.morar.shopfinal.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    int deleteAllById(Long id);

    boolean existsUserById(Long id);
}
