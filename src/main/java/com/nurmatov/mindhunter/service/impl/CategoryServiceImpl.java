package com.nurmatov.mindhunter.service.impl;

import com.nurmatov.mindhunter.domain.entity.userInfo.Category;
import com.nurmatov.mindhunter.domain.exception.ResourceNotFoundException;
import com.nurmatov.mindhunter.repository.CategoryRepository;
import com.nurmatov.mindhunter.service.CategoryService;
import com.nurmatov.mindhunter.web.dto.category.CategoryDto;
import com.nurmatov.mindhunter.web.mapper.category.CategoryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;
    @Override
    public List<CategoryDto> getAllCategory() {
        return categoryMapper.toDtos(categoryRepository.findAll());
    }

    @Override
    public CategoryDto getCategoryById(Long id) {
        return categoryMapper.toDto(categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("NOT_FOUND")));
    }

    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        categoryRepository.save(categoryMapper.toEntity(categoryDto));
        return categoryDto;
    }

    @Override
    public void deleteCategoryById(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public CategoryDto updateCategory(Long id, CategoryDto categoryDto) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("NOT_FOUND"));
        category.setName(categoryDto.getName());
        category.setPositions(categoryDto.getPositions());
        categoryRepository.saveAndFlush(category);
        return categoryDto;

    }
}
