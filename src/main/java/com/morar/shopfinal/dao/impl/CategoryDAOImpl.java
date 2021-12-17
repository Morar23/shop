package com.morar.shopfinal.dao.impl;
import com.morar.shopfinal.dao.CategoryDAO;
import com.morar.shopfinal.dto.CategoryDTO;
import com.morar.shopfinal.entity.Category;
import com.morar.shopfinal.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CategoryDAOImpl implements CategoryDAO {
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryDAOImpl(CategoryRepository categoryRepository) {this.categoryRepository = categoryRepository;}

    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }

    public Category getCategoryByName(String name) {return categoryRepository.findByName(name);}

    @Override
    public Category getCategoryById(Long id) {
        return categoryRepository.getById(id);
    }

    public void saveCategory(CategoryDTO categoryDTO) {
        Category category = new Category();
        category.setName(categoryDTO.getName());
        categoryRepository.saveAndFlush(category);
    }

    public boolean editCategory(CategoryDTO categoryDTO) {
        if (categoryDTO != null && !categoryDTO.getName().isEmpty()) {
            if (categoryRepository.existsCategoriesByName(categoryDTO.getName())) {
                Category category = categoryRepository.findByName(categoryDTO.getName());
                category.setName(categoryDTO.getName());
                categoryRepository.saveAndFlush(category);
                return true;
            }
        }
        return false;
    }

    public boolean deleteCategory(CategoryDTO categoryDTO){
        if (categoryDTO != null && !categoryDTO.getName().isEmpty()) {
            if (categoryRepository.existsCategoriesByName(categoryDTO.getName())) {
                return  categoryRepository.deleteByName(categoryDTO.getName()) > 0;
            }
        }
        return false;
    }
}


