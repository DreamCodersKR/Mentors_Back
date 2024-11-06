package com.dream.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	 @Bean
	    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	        http
	            .csrf(AbstractHttpConfigurer::disable) // CSRF 비활성화 (필요한 경우에만)
	            .authorizeHttpRequests(authorize -> authorize
	                .requestMatchers("/UserJoin", "/UserLogin", "/UserLogout").permitAll() // 특정 엔드포인트 접근 허용
	                .anyRequest().authenticated() // 나머지 요청은 인증 필요
	            )
	            .cors(); // CORS 설정 허용
	        return http.build();
	    }

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true); // 쿠키 사용을 허용
        config.setAllowedOrigins(List.of("http://localhost:8081")); // 허용할 오리진 설정
        config.setAllowedHeaders(List.of("*")); // 모든 헤더 허용
        config.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE")); // 허용할 HTTP 메서드 설정
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
    
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

