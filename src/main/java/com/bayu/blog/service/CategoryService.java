package com.bayu.blog.service;

import com.bayu.blog.payload.CategoryDTO;

public interface CategoryService {

    CategoryDTO addCategory(CategoryDTO categoryDTO);

    CategoryDTO getCategoryById(Long categoryId);
}
