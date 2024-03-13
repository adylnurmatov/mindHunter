package com.nurmatov.mindhunter.web.mapper.category;

import com.nurmatov.mindhunter.domain.entity.userInfo.Category;
import com.nurmatov.mindhunter.web.dto.category.CategoryDto;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

public interface CategoryMapper {
    CategoryDto toDto(Category category);
    List<CategoryDto> toDtos(List<Category> categories);
    Category toEntity(CategoryDto categoryDto);
}
