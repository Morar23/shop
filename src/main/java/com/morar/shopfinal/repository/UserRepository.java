package com.morar.shopfinal.repository;

import com.morar.shopfinal.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    int deleteAllById(Long id);

    boolean existsUserById(Long id);

    boolean existsUserByEmail(String email);

    Optional<User> findByEmail(String email);
}
