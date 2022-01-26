package com.morar.shopfinal.service;

import com.morar.shopfinal.dto.CategoryDTO;
import com.morar.shopfinal.exception.CategoryNotFoundException;
import org.springframework.lang.NonNull;

import java.util.List;

public interface CategoryService {

    List<CategoryDTO> getAllCategories();

    CategoryDTO getCategoryById(Long id) throws CategoryNotFoundException;

    void saveCategory(@NonNull CategoryDTO categoryDTO);

    void updateCategory(@NonNull CategoryDTO categoryDTO) throws CategoryNotFoundException;

    void deleteCategory(Long id) throws CategoryNotFoundException;
}
