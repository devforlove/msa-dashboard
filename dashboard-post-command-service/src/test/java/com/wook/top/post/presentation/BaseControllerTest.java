package com.wook.top.post.presentation;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wook.top.post.config.TestSecurityConfig;
import com.wook.top.publishercore.config.EventConfig;
import com.wook.top.webcore.member.Role;
import com.wook.top.webcore.security.JwtAuthorizationFilter;
import com.wook.top.webcore.security.JwtTokenProvider;
import com.wook.top.webcore.security.SecurityUser;
import config.MemberClientConfig;
import config.MockServerConfig;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

@Import({MockServerConfig.class, MemberClientConfig.class, TestSecurityConfig.class, EventConfig.class})
@SpringBootTest
@Transactional
@AutoConfigureMockMvc
public abstract class BaseControllerTest {

	@Autowired
	protected MockMvc mockMvc;

	@Autowired
	protected ObjectMapper objectMapper;

	@Autowired
	protected UserDetailsService userDetailsService;

	@BeforeEach
	public void securitySetUp() {
		when(userDetailsService.loadUserByUsername(anyString())).thenReturn(securityUser());
	}

	private SecurityUser securityUser() {
		return SecurityUser.builder()
				.memberId(1L)
				.email("test@example.com")
				.password("password")
				.nickname("nickname")
				.roles(Set.of(Role.MEMBER))
				.build();
	}
}
