package com.dream.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class QuestionDetailDto {
	private Integer questionIdx;
	private String responseContent;
	private String biosTitle;
	private Integer parentCategoryId;
	private String subCategoryName;
}
