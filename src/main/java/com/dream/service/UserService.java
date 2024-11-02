package com.dream.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dream.entity.Tb_User;
import com.dream.repository.UserRepository;



@Service
public class UserService {
	@Autowired
	UserRepository UserRepo;
	
	
	public void UserJoin(Tb_User user){
		if(user.getGender().equals("남자")) {
			user.setGender("M");
		}else {
			user.setGender("W");
		}
		if(user.getMemberType()=="주니어") {
			user.setMemberType("J");
		}else {
			user.setMemberType("S");
		}
		UserRepo.save(user);
	}
	
}