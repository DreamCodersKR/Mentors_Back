package com.dream.dto;

import lombok.Data;
import java.util.List;

@Data
public class CategoryDto {
    private Integer categoryIdx;
    private String categoryName;
    private List<SubCategoryDto> subCategories;
}
