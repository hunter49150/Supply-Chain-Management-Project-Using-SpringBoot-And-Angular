package com.project.configuration;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import jakarta.servlet.http.HttpServletRequest;

@Configuration
public class CorsConfig {
	@Bean
	public CorsConfigurationSource corsConfigSource() {
		CorsConfiguration configuration = new CorsConfiguration();
		configuration.setAllowedOrigins(Collections.singletonList("*")); // Allow requests from any origin. You can specify specific origins if needed.
        configuration.addAllowedMethod("*"); // Allow all HTTP methods.
        configuration.addAllowedHeader("*"); // Allow all headers.
        configuration.setAllowCredentials(true); // Allow credentials (e.g., cookies).
        
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        
        
		return source;
	} 
}
