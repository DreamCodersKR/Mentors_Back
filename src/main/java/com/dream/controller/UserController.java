 package com.dream.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.dream.entity.Tb_User;
//import com.dream.repository.MemberRepository;
import com.dream.repository.UserRepository;
import com.dream.service.UserService;

import jakarta.servlet.http.HttpSession;

@RestController
public class UserController {
//	@Autowired
//	MemberMapper Mapper;
//	
//	@Autowired
//	MemberMapper memberMapper;
//	
	@Autowired
	UserService UserService;
	
//	 회원 가입
	@PostMapping("/UserJoin")
	public  ResponseEntity<Map<String, Object>> MemberJoin(@RequestBody Tb_User user){
		// Vue js에서 보낸 데이터 처리
		System.out.println("Vue에서 받은 Post 데이터 : " + user);
		UserService.UserJoin(user);
		
		 Map<String, Object> result = new HashMap<>();
		 result.put("email", user.getEmail());
		 result.put("memberType", user.getMemberType());
		
		return ResponseEntity.ok(result);
	}
//	// 로그인
//	@RequestMapping("/Real_Login")
//	public String Real_Login(String memId, String memPw, HttpSession session) {
//		
//		
//		
//		 TblMember member = MemRepo.findByMemId(memId);
//		 boolean checkPassword = memberService.checkPassword(memId, memPw);
//		 
//		 
//		if (checkPassword == true && member.getMemDel().equals("N")) {
//			session.setAttribute("user", member);
//			session.setAttribute("msg", "로그인 성공했습니다.");
//
//		} else {
//			session.setAttribute("msg", "로그인 실패했습니다. 다시 시도해주세요.");
//			return "Login";
//		}
//		return "redirect:main";
//	}



//	// 로그아웃
//	@RequestMapping("/Logout")
//	public String Logout(HttpSession session) {
//		session.invalidate();
//		return "redirect:main";
//	}
//
//	// 카카오 로그인
//	@RequestMapping("/KakaoLogSuc")
//	public String KakaoLogSuc(String nickname, HttpSession session) {
//
//		session.setAttribute("user_nick", nickname);
//
//		return "redirect:main";
//	}
//	

//
//	// 회원정보 수정
//	@RequestMapping("/M_modify")
//	public String M_modify(TblMember member, HttpSession session) {
//
//		TblMember user = (TblMember) session.getAttribute("user");
//
//		member.setMemId(user.getMemId());
//
//		MemRepo.save(member);
//
//		session.setAttribute("user", member);
//
//		return "redirect:main";
//	}
//
//	// 회원탈퇴
//	@RequestMapping("/M_delete")
//	public String M_delete(TblMember member, HttpSession session) {
//
//		TblMember user = (TblMember) session.getAttribute("user");
//
//		member.setMemId(user.getMemId());
//		member.setMemDel("Y");
//		MemRepo.save(member);
//
//		session.removeAttribute("user");
//		return "redirect:main";
//	}

//
//	// 아이디 중복 체크
//	@GetMapping("/idCheck")
//	public ResponseEntity<Boolean> checkId(@RequestParam("memId") String memId) {
//		boolean isDuplicate = MemRepo.existsByMemId(memId);
//		return ResponseEntity.ok(isDuplicate);
//	}

}