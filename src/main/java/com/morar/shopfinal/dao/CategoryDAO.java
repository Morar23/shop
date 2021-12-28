package com.morar.shopfinal.dao;

import com.morar.shopfinal.dto.CategoryDTO;
import com.morar.shopfinal.entity.Category;

import java.util.List;

public interface CategoryDAO {
    List<Category> getAllCategory();

    Category getCategoryByName(String name);

    Category getCategoryById(Long id);

    boolean editCategory(CategoryDTO categoryDTO);

    boolean deleteCategory(CategoryDTO categoryDTO);
}
