package com.wook.top.postcommandclient.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {

	@Bean
	public PostClientInterceptor postClientInterceptor() {
		return new PostClientInterceptor();
	}
}
