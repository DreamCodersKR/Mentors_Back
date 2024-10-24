package com.dream.service;
//import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;



//@Service
//public class MemberService {
//	
//	@Autowired
//	private BCryptPasswordEncoder passwordEncoder;
//	@Autowired
//	MemberRepository MemRepo;
//	
//	 public  String encryptedPassword(String memPw) {
//		 	String encryptedPasswordString = passwordEncoder.encode(memPw);
//		 
//	        return encryptedPasswordString;
//	    }
//	 public  boolean checkPassword(String memId,String memPw) {
//		 TblMember member= MemRepo.findByMemId(memId);
//		 if(member !=null) {
//			 return passwordEncoder.matches(memPw, member.getMemPw());
//		 }
//	        return false;
//	    }
//}