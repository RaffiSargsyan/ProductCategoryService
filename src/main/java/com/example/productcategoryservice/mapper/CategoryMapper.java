package com.example.productcategoryservice.mapper;

import com.example.productcategoryservice.dto.CategoryResponse;
import com.example.productcategoryservice.dto.CreateCategory;
import com.example.productcategoryservice.entity.Category;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    Category map(CreateCategory createCategory);
    CategoryResponse map(Category category);
    List<CategoryResponse> map(List<Category> categoryList);
}
