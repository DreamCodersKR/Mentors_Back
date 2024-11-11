package com.dream.Mentors;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.dream.entity.Tb_User;
import com.dream.repository.UserRepository;
import com.dream.service.UserService;

@SpringBootTest
public class testPasswordEncodingAndMatching {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepository userRepository;

	@Test
	public void testCheckPassword() {
		// 테스트용 사용자 생성
		String rawPassword = "12311";
		String email = "test1233@test.com";
		
		// 새 사용자 저장
		Tb_User user = new Tb_User();
		user.setEmail(email);
		user.setPassword(userService.encryptedPassword(rawPassword));
		user.setName("Test User");
		user.setNickname("Tester");
		user.setGender("M");
		user.setBirthDate(java.sql.Date.valueOf("2000-01-01"));
		user.setUserCategory("j");
		user.setMentorYn("N");
		userRepository.save(user); // 데이터베이스에 저장
		
		// 비밀번호 검증
		boolean isMatch = userService.checkPassword(email, rawPassword);
		
		Assertions.assertTrue(isMatch, "비밀번호 검증에 실패했습니다.");

		// 테스트 후 데이터 정리
		userRepository.delete(user);
	}
}