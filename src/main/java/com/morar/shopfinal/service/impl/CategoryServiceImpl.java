package com.morar.shopfinal.service.impl;

import com.morar.shopfinal.dao.CategoryDAO;
import com.morar.shopfinal.dto.CategoryDTO;
import com.morar.shopfinal.entity.Category;
import com.morar.shopfinal.exception.CategoryNotFoundException;
import com.morar.shopfinal.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryDAO categoryDAO;

    @Autowired
    public CategoryServiceImpl(CategoryDAO categoryDAO) {
        this.categoryDAO = categoryDAO;
    }

    @Override
    public List<CategoryDTO> getAllCategories() {
        List<Category> categories = categoryDAO.getAllCategories();
        return categories.stream().map(el -> new CategoryDTO(el.getId(), el.getName())).collect(Collectors.toList());
    }

    @Override
    public CategoryDTO getCategoryById(Long id) throws CategoryNotFoundException {
        Category category = categoryDAO.getCategoryById(id);
        return new CategoryDTO(
                category.getId(),
                category.getName()
        );
    }

    @Override
    public void saveCategory(@NonNull CategoryDTO categoryDTO) {
        categoryDAO.saveCategory(categoryDTO);
    }

    @Override
    public void updateCategory(@NonNull CategoryDTO categoryDTO) throws CategoryNotFoundException {
        categoryDAO.updateCategory(categoryDTO);
    }

    @Override
    public void deleteCategory(Long id) throws CategoryNotFoundException {
        categoryDAO.deleteCategory(id);
    }
}
