package com.morar.shopfinal.service;

import com.morar.shopfinal.dto.CategoryDTO;
import com.morar.shopfinal.exception.impl.CategoryNotFoundException;
import org.springframework.lang.NonNull;

import java.util.List;

public interface CategoryService {

    List<CategoryDTO> getAllCategories();

    CategoryDTO getCategoryById(Long id) throws CategoryNotFoundException;

    CategoryDTO saveCategory(@NonNull CategoryDTO categoryDTO);

    CategoryDTO updateCategory(@NonNull CategoryDTO categoryDTO) throws CategoryNotFoundException;

    void deleteCategory(Long id) throws CategoryNotFoundException;
}
