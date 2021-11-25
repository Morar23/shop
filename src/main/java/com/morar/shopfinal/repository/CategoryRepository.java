package com.morar.shopfinal.repository;

import com.morar.shopfinal.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository <Category, Long> {
}
