package com.nurmatov.mindhunter.service.impl;

import com.nurmatov.mindhunter.service.CategoryService;
import com.nurmatov.mindhunter.web.dto.category.CategoryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    @Override
    public List<CategoryDto> getAllCategory() {
        return null;
    }

    @Override
    public CategoryDto getCategoryById(Long id) {
        return null;
    }

    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        return null;
    }

    @Override
    public void deleteCategoryById(Long id) {

    }

    @Override
    public CategoryDto updateCategory(Long id, CategoryDto categoryDto) {
        return null;
    }
}
