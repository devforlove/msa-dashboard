package com.wook.top.post.config;

import static org.mockito.Mockito.mock;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetailsService;

@TestConfiguration
public class TestSecurityConfig {

	@Bean
	public UserDetailsService userDetailsService() {
		return mock(UserDetailsService.class);
	}
}
