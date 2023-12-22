package com.wook.top.postcommand.postquery;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PostQueryFeignConfig {

	@Bean
	public PostClientInterceptor postClientInterceptor() {
		return new PostClientInterceptor();
	}
}
