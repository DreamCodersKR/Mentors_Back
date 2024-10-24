package com.dream.Mentors;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class TestController {
	
	@PostMapping("/testPostData")
	public ResponseEntity<String> receiveDataFromVuePost (@RequestBody Map<String, String> requestData) {

		// Vue js에서 보낸 데이터 처리
		String message = requestData.get("message");
		System.out.println("Vue에서 받은 Post 데이터 : " + message);
		
		// flask 서버로 데이터 전송
		String flaskUrl = "http://localhost:5000/receiveTestData";
		RestTemplate restTemplate = new RestTemplate();
		
		// flask 서버로 보낼 데이터
		ResponseEntity<String> response = restTemplate.postForEntity(flaskUrl, requestData, String.class);
		
		System.out.println("Flask 응답: " + response.getBody());
		
		
		// 응답 리턴
		return ResponseEntity.ok(response.getBody());
		
	}
	
	@GetMapping("/testGetData")
	public ResponseEntity<String> receiveDataFromVueGet (@RequestParam(value = "message", required = false, defaultValue = "default") String message) {
		
		System.out.println("Vue에서 받은 Get 데이터 : " + message);
		
		
		// Flask 서버로 데이터 전달하기
		String encodingData = URLEncoder.encode(message, StandardCharsets.UTF_8);
		System.out.println("인코딩 체크  " + encodingData);
		
		String flaskUrl = "http://localhost:5000/receiveTestGetData?message=" + encodingData;
		RestTemplate restTemplate = new RestTemplate();
		
		ResponseEntity<String> response = restTemplate.getForEntity(flaskUrl, String.class);
		System.out.println("Flask 응답: " + response.getBody());
		
		// 응답 반환
		return ResponseEntity.ok(response.getBody());
		
	}
	
}
