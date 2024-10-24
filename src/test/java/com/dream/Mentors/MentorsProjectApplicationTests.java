package com.dream.Mentors;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MentorsProjectApplicationTests {
	@Autowired
	 private WebClient.Builder webClientBuilder;
	
	@Test
	public void testSendToFlask() {
        // WebClient 생성
        WebClient webClient = webClientBuilder.baseUrl("http://localhost:5000").build();

        // 테스트용 데이터 생성
        Map<String, Object> requestData = new HashMap<>();
        requestData.put("key", "value");
        requestData.put("message", "Hello Flask");

        // Flask 서버로 POST 요청 보내고 응답 받기
        String response = webClient.post()
                .uri("/testFlask")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(requestData)
                .retrieve()
                .bodyToMono(String.class)
                .block();  // 비동기 Mono를 동기적으로 변환

        // 응답이 비어있지 않은지 확인
        assertThat(response).isNotNull();
        System.out.println("Response from Flask: " + response);
    }
}
