package com.bayu.blog.service;

import com.bayu.blog.payload.CategoryDTO;

import java.util.List;

public interface CategoryService {

    CategoryDTO addCategory(CategoryDTO categoryDTO);

    CategoryDTO getCategoryById(Long categoryId);

    List<CategoryDTO> getAllCategories();
}
