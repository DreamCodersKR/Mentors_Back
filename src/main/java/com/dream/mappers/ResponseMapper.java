package com.dream.mappers;

import org.apache.ibatis.annotations.Mapper;

import com.dream.entity.Tb_Bios;
import com.dream.entity.Tb_Bios_Detail;

@Mapper
public interface ResponseMapper {
	void insertBios(Tb_Bios bios);
	void insertBiosDetail(Tb_Bios_Detail biosDetail);
}
