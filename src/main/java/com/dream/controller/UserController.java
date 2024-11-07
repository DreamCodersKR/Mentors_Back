package com.dream.controller;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dream.entity.Tb_Token;
import com.dream.entity.Tb_User;
import com.dream.service.UserService;
import jakarta.servlet.http.HttpSession;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	// 세션정보 반환
	@GetMapping("/userSessionInfo")
	public ResponseEntity<Map<String, Object>> getUserSessionInfo(HttpSession session) {
		Map<String, Object> sessionInfo = new HashMap<>();
		
		// 세션에서 정보 가져오기
		String userToken = (String) session.getAttribute("userToken");
		String userName = (String) session.getAttribute("userName");
		String userCategory = (String) session.getAttribute("userCategory");
		String premiumYn = (String) session.getAttribute("premiumYn");
		String mentorYn = (String) session.getAttribute("mentorYn");

		if (userToken != null) {
			sessionInfo.put("userToken", userToken);
			sessionInfo.put("userName", userName);
			sessionInfo.put("userCategory", userCategory);
			sessionInfo.put("premiumYn", premiumYn);
			sessionInfo.put("mentorYn", mentorYn);
			return ResponseEntity.ok(sessionInfo);
		} else {
			sessionInfo.put("error", "No session found");
			return ResponseEntity.status(403).body(sessionInfo);
		}
	}

//	 회원 가입
	@PostMapping("/userJoin")
	public ResponseEntity<Map<String, Object>> userJoin(@RequestBody Tb_User user) {
		// Vue js에서 보낸 데이터 처리
//		System.out.println("Vue에서 받은 Post 데이터 : " + user);

		Map<String, Object> result = new HashMap<>();

		// 비밀번호 암호화 인코딩
		String hashedUserPw = userService.encryptedPassword(user.getPassword());
		user.setPassword(hashedUserPw);

		// 회원가입
		userService.UserJoin(user);

		// 회원정보 리턴
		result.put("email", user.getEmail());
		result.put("memberType", user.getUserCategory());
		return ResponseEntity.ok(result);
	}

	// 로그인
	@PostMapping("/userLogin")
	public ResponseEntity<Map<String, Object>> userLogin(@RequestBody Tb_User user, HttpSession session) {

		Map<String, Object> result = new HashMap<>();

		String email = user.getEmail();
		String password = user.getPassword();
		
//		비밀번호 일치여부 체크
		boolean checkPassword = userService.checkPassword(email, password);
		
//		비밀번호 일치할 경우
		if(checkPassword) {
			 Tb_Token token =  userService.getToken(email);
			 // 토큰 인증 만료여부체크
			 if(token.getExpireDate().isAfter(LocalDateTime.now())){
				 // 세션에 토큰저장
				 session.setAttribute("userToken",token.getUserToken());
			 }else {
				// 토큰이 만료된 경우 - 추후에 재발급 로직추가해야함
	            result.put("message", "토큰이 만료되었습니다. 다시 로그인 해주세요.");
	            return ResponseEntity.status(403).body(result);
			 }
			 
			Tb_User userInfo = userService.getUserInfo(email); 		
			result.put("name", userInfo.getName());
			result.put("email", userInfo.getEmail());
			result.put("userCate", userInfo.getUserCategory());
			result.put("mentorYn", userInfo.getMentorYn());
			// 세션에 추가정보 저장
			session.setAttribute("userName", userInfo.getName());
			session.setAttribute("userCategory", userInfo.getUserCategory());
			session.setAttribute("premiumYn", userInfo.getPremiumYn());
			session.setAttribute("mentorYn", userInfo.getMentorYn());
			session.setAttribute("userEmail", userInfo.getEmail());
			return ResponseEntity.ok(result);
		}
//		비밀번호 틀렸을 경우
		else {
	        result.put("message", "잘못된 이메일 또는 비밀번호입니다.");
	        return ResponseEntity.status(401).body(result);
		}
		
	}
}
