package com.example.stockspring.controller;

import com.example.stockspring.controller.api.CategoryApi;
import com.example.stockspring.dto.CategoryDto;
import com.example.stockspring.exception.InvalidOperationException;
import com.example.stockspring.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController implements CategoryApi {

    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    public CategoryDto save(CategoryDto dto) {
        return categoryService.save(dto);
    }

    @Override
    public CategoryDto findById(Integer idCategory) {
        return categoryService.findById(idCategory);
    }

    @Override
    public CategoryDto findByCodeCategory(String codeCategory) {
        return categoryService.findByCode(codeCategory);
    }

    @Override
    public List<CategoryDto> findAll() {
        return categoryService.findAll();
    }

    @Override
    public String delete(Integer id) {
        try {
            categoryService.delete(id);
            return "Category deleted successfully";
        } catch (IllegalAccessError error) {
            return error.getMessage();
        }
    }
}
