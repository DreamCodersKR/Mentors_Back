package com.dream.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.dream.entity.Tb_Token;
import com.dream.entity.Tb_User;
import com.dream.mappers.UserMapper;
import com.dream.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepo;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	 @Autowired
	 private UserMapper userMapper;
	
	// 회원가입
	public void UserJoin(Tb_User user) {
		userRepo.save(user);
	}

	// 비밀번호 암호화
	public String encryptedPassword(String password) {
		String encryptedPasswordString = passwordEncoder.encode(password);

		return encryptedPasswordString;
	}
	// 암호화 된 비밀번호 디코딩
	public boolean checkPassword(String email,String password) {
		 Tb_User user= userRepo.findByEmail(email);
		 if(user !=null && user.getUserDel().equals("N")) {
			 return passwordEncoder.matches(password, user.getPassword());
		 }
	        return false;
	    }
	
	
	
	//유저 토큰 가져오기
	public Tb_Token getToken(String email) {
		Tb_Token token = userMapper.getToken(email);
		return token;
	}
	
	//유저 정보 가져오기
	public Tb_User getUserInfo(String email) {
		Tb_User user = userMapper.getUserInfo(email);
		return user;
	}
	
}