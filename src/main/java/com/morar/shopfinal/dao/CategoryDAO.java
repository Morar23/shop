package com.morar.shopfinal.dao;

import com.morar.shopfinal.dto.CategoryDTO;
import com.morar.shopfinal.entity.Category;
import com.morar.shopfinal.exception.impl.CategoryIsAlreadyExistException;
import com.morar.shopfinal.exception.impl.CategoryNotFoundException;
import org.springframework.lang.NonNull;

import java.util.List;

public interface CategoryDAO {
    List<Category> getAllCategories();

    Category getCategoryById(Long id) throws CategoryNotFoundException;

    Category updateCategory(@NonNull CategoryDTO categoryDTO) throws CategoryNotFoundException;

    Category saveCategory(@NonNull CategoryDTO categoryDTO) throws CategoryIsAlreadyExistException;

    void deleteCategory(Long id) throws CategoryNotFoundException;
}
