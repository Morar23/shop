package com.morar.shopfinal.repository;

import com.morar.shopfinal.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository <Category, Long> {

    Category findByName(String name);

    boolean existsCategoriesByName(String name);

    long deleteByName(String name);

}
