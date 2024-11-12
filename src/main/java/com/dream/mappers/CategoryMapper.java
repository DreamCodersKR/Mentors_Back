package com.dream.mappers;

import com.dream.dto.CategoryDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CategoryMapper {
    CategoryDto getCategoryWithSubcategories(@Param("categoryId") int categoryId);
}
