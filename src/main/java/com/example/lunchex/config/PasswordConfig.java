package com.example.lunchex.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

//テキストP16
@SuppressWarnings("deprecation")
@Configuration
public class PasswordConfig {
@Bean
	public PasswordEncoder passwordEncoder() {
	// エンコードの設定
	return NoOpPasswordEncoder.getInstance();
	}
}