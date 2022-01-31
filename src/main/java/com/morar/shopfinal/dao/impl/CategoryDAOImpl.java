package com.morar.shopfinal.dao.impl;

import com.morar.shopfinal.dao.CategoryDAO;
import com.morar.shopfinal.dto.CategoryDTO;
import com.morar.shopfinal.entity.Category;
import com.morar.shopfinal.exception.impl.CategoryNotFoundException;
import com.morar.shopfinal.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class CategoryDAOImpl implements CategoryDAO {
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryDAOImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public @NonNull
    List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategoryById(Long id) throws CategoryNotFoundException {
        return categoryRepository.findById(id).orElseThrow(CategoryNotFoundException::new);
    }

    @Override
    public Category updateCategory(@NonNull CategoryDTO categoryDTO) throws CategoryNotFoundException {
        Category category = categoryRepository.findById(categoryDTO.getId()).orElseThrow(CategoryNotFoundException::new);
        category.setName(categoryDTO.getName());
        categoryRepository.saveAndFlush(category);
        return category;
    }

    @Override
    public Category saveCategory(@NonNull CategoryDTO categoryDTO) {
        Category category = new Category();
        category.setName(categoryDTO.getName());
        categoryRepository.saveAndFlush(category);
        return category;
    }

    @Override
    public void deleteCategory(Long id) throws CategoryNotFoundException {
        if (categoryRepository.deleteAllById(id) == 0) {
            throw new CategoryNotFoundException();
        }
    }
}


