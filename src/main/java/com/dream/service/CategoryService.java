package com.dream.service;

import com.dream.dto.CategoryDto;
import com.dream.mappers.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
	
	@Autowired
    private CategoryMapper categoryMapper;

    public CategoryDto getCategoryWithSubcategories(Integer categoryId) {
        return categoryMapper.getCategoryWithSubcategories(categoryId);
    }
}
