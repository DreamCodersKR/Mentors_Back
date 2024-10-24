package com.dream.Mentors;  // 이 패키지 내에 클래스를 생성

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration // 해당 클래스가 설정클래스임
public class WebConfig implements WebMvcConfigurer { // Spring MVC 설정을 커스터마이징 할 수 있는 인터페이스 (WebMvcConfigurer)

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")  // 모든 경로에 대해 CORS 허용
                .allowedOrigins("http://localhost:8081")  // Vue.js가 실행되는 포트 허용
                .allowedMethods("GET", "POST", "PUT", "DELETE")  // 허용할 HTTP 메서드
                .allowedHeaders("*")  // 모든 헤더 허용
                .allowCredentials(true);  // 자격 증명 허용 (인증 관련)
    }
}
