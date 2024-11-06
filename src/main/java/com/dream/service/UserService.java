package com.dream.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.dream.entity.Tb_User;
import com.dream.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository UserRepo;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	
	// 회원가입
	public void UserJoin(Tb_User user) {
		UserRepo.save(user);
	}

	// 비밀번호 암호화
	public String encryptedPassword(String password) {
		String encryptedPasswordString = passwordEncoder.encode(password);

		return encryptedPasswordString;
	}
	// 암호화 된 비밀번호 디코딩
	public boolean checkPassword(String email,String password) {
		 Tb_User user= UserRepo.findByEmail(email);
		 if(user !=null && user.getUserDel().equals("N")) {
			 return passwordEncoder.matches(password, user.getPassword());
		 }
	        return false;
	    }
	

}