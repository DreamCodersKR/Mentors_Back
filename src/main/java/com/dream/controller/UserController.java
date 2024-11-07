 package com.dream.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.dream.entity.Tb_User;
import com.dream.service.UserService;
import jakarta.servlet.http.HttpSession;

@RestController
public class UserController {
	
	    @Autowired
	    private UserService userService;
	    
//	 회원 가입
	@PostMapping("/userJoin")
	public  ResponseEntity<Map<String, Object>> UserJoin(@RequestBody Tb_User user){
		// Vue js에서 보낸 데이터 처리
		System.out.println("Vue에서 받은 Post 데이터 : " + user);
		
		Map<String, Object> result = new HashMap<>();
		
		//비밀번호 암호화 인코딩
		String hashedUserPw= userService.encryptedPassword(user.getPassword());
		user.setPassword(hashedUserPw);
		
		//회원가입
		userService.UserJoin(user);
		
		//회원정보 리턴
		result.put("email", user.getEmail());
		result.put("memberType", user.getUserCategory());
		return ResponseEntity.ok(result);
	}
	//로그인
	@PostMapping("/userLogin")
	public String UserLogin(@RequestBody Tb_User user, HttpSession session) {
		
		String email = user.getEmail();
		String password = user.getPassword();
		System.out.println(email);
		System.out.println(password);
		boolean checkPassword = userService.checkPassword(email, password);
		System.out.println(checkPassword);
		

		
		return "dd";
	}
}




