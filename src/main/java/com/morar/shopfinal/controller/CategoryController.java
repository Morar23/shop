package com.morar.shopfinal.controller;

import com.morar.shopfinal.dao.impl.CategoryDAOImpl;
import com.morar.shopfinal.dto.CategoryDTO;
import com.morar.shopfinal.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {
    private final CategoryDAOImpl categoryDAO;
    @Autowired
    public CategoryController(CategoryDAOImpl categoryDAO) {this.categoryDAO = categoryDAO;}

    @GetMapping(value = "/categories")
    public List<Category> getName(){
        return categoryDAO.getAllCategory();
    }

    @GetMapping(value = "/category")
    public Category getCategoryByName(@RequestParam(required = false)String value) {
        return  categoryDAO.getCategoryByName(value);
    }

    @PostMapping(value = "/category", consumes = "application/json")
    public HttpStatus saveCategory(@RequestBody CategoryDTO categoryDTO){
        categoryDAO.saveCategory(categoryDTO);
        return HttpStatus.CREATED;
    }

    @PutMapping(value = "/category", consumes = "application/json")
    public HttpStatus editUser(@RequestBody CategoryDTO categoryDTO) {
        return categoryDAO.editCategory(categoryDTO) ? HttpStatus.ACCEPTED : HttpStatus.EXPECTATION_FAILED;
    }

    @DeleteMapping(value = "/category", consumes = "application/json")
    public HttpStatus deleteUser(@RequestBody CategoryDTO categoryDTO) {
        return categoryDAO.deleteCategory(categoryDTO) ? HttpStatus.ACCEPTED : HttpStatus.EXPECTATION_FAILED;
    }



}
