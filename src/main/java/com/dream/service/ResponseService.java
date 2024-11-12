package com.dream.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dream.dto.QuestionDetailDto;
import com.dream.dto.ResponseDto;
import com.dream.entity.Tb_Bios;
import com.dream.entity.Tb_Bios_Detail;
import com.dream.mappers.ResponseMapper;

@Service
public class ResponseService {
	
	@Autowired
	private ResponseMapper responseMapper;
	
	public int saveResponse(ResponseDto responseDto) {
		// tb_bios 데이터 저장하기
		Tb_Bios bios = new Tb_Bios();
		bios.setUserEmail(responseDto.getUserEmail());
		bios.setResponseType(responseDto.getResponseType());
		responseMapper.insertBios(bios);
		
		Integer biosIdx = bios.getBiosIdx();
		
		if(biosIdx == null) throw new RuntimeException("Failed to retrieve generated bios_idx");
		
		// tb_bios_detail 데이터 저장
		
		for (QuestionDetailDto question : responseDto.getQuestions()) {
			Tb_Bios_Detail detail = new Tb_Bios_Detail();
			detail.setBiosIdx(biosIdx);
			detail.setBiosTitle(question.getBiosTitle());
			detail.setQuestionIdx(question.getQuestionIdx());
			detail.setDetailContent(question.getResponseContent());
			detail.setParentCategoryId(question.getParentCategoryId());
			detail.setSubCategoryName(question.getSubCategoryName());
			responseMapper.insertBiosDetail(detail);
		}
		
		return bios.getBiosIdx();
	}
	
}
