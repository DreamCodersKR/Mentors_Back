package com.dream.Mentors;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class testController {
	
	@PostMapping("/testData")
	public ResponseEntity<String> receiveDataFromVue (@RequestBody Map<String, String> requestData) {

		// Vue js에서 보낸 데이터 처리
		String message = requestData.get("message");
		System.out.println("Vue에서 받은 데이터 : " + message);
		
		// flask 서버로 데이터 전송
		String flaskUrl = "http://localhost:5000/receiveTestData";
		RestTemplate restTemplate = new RestTemplate();
		
		// flask 서버로 보낼 데이터
		ResponseEntity<String> response = restTemplate.postForEntity(flaskUrl, requestData, String.class);
		
		System.out.println("Flask 응답: " + response.getBody());
		
		
		// 응답 리턴
		return ResponseEntity.ok("Data received and response : " + response.getBody());
		
	}
	
}
