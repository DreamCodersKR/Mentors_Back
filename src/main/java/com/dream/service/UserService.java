package com.dream.service;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dream.entity.Tb_User;
import com.dream.repository.UserRepository;



@Service
public class UserService {
	@Autowired
	UserRepository UserRepo;
	
	public void UserJoin(Tb_User user){

		UserRepo.save(user);
	}
	
	public boolean UserLogin(String email, String password) {
		Tb_User userInfo = UserRepo.findByEmail(email);
		if(userInfo != null) {
			if(userInfo.getPassword().equals(password)) {
				return true;
			}else {
				return false;
			}
		}else {
			return false;
		}
	}
	
}