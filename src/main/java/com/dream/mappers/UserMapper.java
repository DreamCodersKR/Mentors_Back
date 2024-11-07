package com.dream.mappers;

import org.apache.ibatis.annotations.Mapper;

import com.dream.entity.Tb_Token;
import com.dream.entity.Tb_User;



@Mapper
public interface UserMapper {
	
public Tb_Token getToken(String email);

public Tb_User getUserInfo(String email);
	
	
	
}
