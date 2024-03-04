package com.wook.top.post.config;

import static org.mockito.Mockito.mock;

import com.wook.top.webcore.security.JwtAuthorizationFilter;
import com.wook.top.webcore.security.JwtTokenProvider;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.security.core.userdetails.UserDetailsService;

@Import({JwtAuthorizationFilter.class, JwtTokenProvider.class})
@TestConfiguration
public class TestSecurityConfig {

	@Bean
	public UserDetailsService userDetailsService() {
		return mock(UserDetailsService.class);
	}
}
