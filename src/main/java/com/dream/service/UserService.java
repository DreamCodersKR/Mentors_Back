package com.dream.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.dream.entity.Tb_Token;
import com.dream.entity.Tb_User;
import com.dream.mappers.UserMapper;
import com.dream.repository.UserRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepo;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private UserMapper userMapper;

    // 회원가입
    public Map<String, Object> userJoin(Tb_User user) {
        Map<String, Object> response = new HashMap<>();

        // 중복 이메일 확인
        Optional<Tb_User> existingUser = userRepo.findByEmail(user.getEmail());
        if (existingUser.isPresent()) {
            response.put("status", "fail");
            response.put("message", "이미 사용 중인 이메일입니다.");
            return response;
        }

        userRepo.save(user);

        response.put("status", "success");
        response.put("message", "회원가입이 완료되었습니다.");
        return response;
    }

    // 비밀번호 암호화
    public String encryptedPassword(String password) {
        return passwordEncoder.encode(password);
    }

    // 암호화된 비밀번호 검증
    public boolean checkPassword(String email, String password) {
    	
    	System.out.println("로그인 시도 이메일: " + email);
    	System.out.println("입력된 비밀번호: " + password);
        
    	Optional<Tb_User> user = userRepo.findByEmail(email);
        
    	if (user.isEmpty()) {
    	    System.out.println("이메일이 존재하지 않음.");
    	    return false;
    	}
    	
    	boolean isPasswordMatch = user.isPresent() && passwordEncoder.matches(password, user.get().getPassword());

    	return isPasswordMatch;
    }

    // 유저 토큰 가져오기
    public Tb_Token getToken(String email) {
        return userMapper.getToken(email);
    }

    // 유저 정보 가져오기
    public Tb_User getUserInfo(String email) {
        return userMapper.getUserInfo(email);
    }
    
    // 이메일 중복 확인 로직
    public boolean isEmailExists(String email) {
        Tb_User existingUser = userMapper.getUserInfo(email);
        return existingUser != null; 
    }
}
