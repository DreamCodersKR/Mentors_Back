package com.dream.controller;

import com.dream.dto.CategoryDto;
import com.dream.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/{categoryId}")
    public ResponseEntity<CategoryDto> getCategoryWithSubcategories(@PathVariable("categoryId") Integer categoryId) {
        CategoryDto categoryDto = categoryService.getCategoryWithSubcategories(categoryId);
        if (categoryDto != null) {
            return ResponseEntity.ok(categoryDto);
        } else {
            return ResponseEntity.noContent().build();
        }
    }
}
