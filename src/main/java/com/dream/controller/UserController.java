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
	@PostMapping("/UserJoin")
	public  ResponseEntity<Map<String, Object>> UserJoin(@RequestBody Tb_User user){
		// Vue js에서 보낸 데이터 처리
		System.out.println("Vue에서 받은 Post 데이터 : " + user);
		Map<String, Object> result = new HashMap<>();
		
		userService.UserJoin(user);

		result.put("email", user.getEmail());
		result.put("memberType", user.getUserCategory());
		return ResponseEntity.ok(result);
	}
	//로그인
	@PostMapping("/UserLogin")
	public String UserLogin(@RequestBody Tb_User user, HttpSession session) {
		
		boolean checkUser = userService.UserLogin(user.getEmail(),user.getPassword());
		System.out.println(checkUser);
		if (checkUser==true) {
            // 세션에 사용자 정보 저장
            session.setAttribute("username", user.getName());
            return "Login successful";
        } else {
            return "Invalid username or password";
        }
    }
	
}




