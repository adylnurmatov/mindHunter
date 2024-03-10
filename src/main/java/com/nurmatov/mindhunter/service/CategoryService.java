package com.nurmatov.mindhunter.service;

import com.nurmatov.mindhunter.web.dto.category.CategoryDto;

import java.util.List;

public interface CategoryService {
    List<CategoryDto> getAllCategory();

    CategoryDto getCategoryById(Long id);

    CategoryDto createCategory(CategoryDto categoryDto);

    void deleteCategoryById(Long id);

    CategoryDto updateCategory(Long id, CategoryDto categoryDto);
}
