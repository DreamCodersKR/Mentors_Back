package com.dream.Mentors;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class FlaskCommunicationController {
	@GetMapping("/test_flask")
	public String getDataFromFlask() {
		String url = "http://localhost:5000/testFlask"; // Flask 서버의 엔드포인트
		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

		return "Flask에서 받은 데이터: " + response.getBody();
	}
}
