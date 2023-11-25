package com.wook.top.member.config.security.api;

import static org.junit.jupiter.api.Assertions.*;

import com.wook.top.member.config.security.SecurityUser;
import com.wook.top.testFixture.SecurityUserFixture;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
@DisplayName("JwtTokenProvider 테스트")
class JwtTokenProviderTest {

	@InjectMocks
	JwtTokenProvider jwtTokenProvider;

	SecurityUser securityUser;

	@BeforeEach
	void setup() {
		securityUser = SecurityUserFixture.MEMBER.getSecurityUser();
	}

	@Test
	void withSecurityUser_GenerateToken() {
		jwtTokenProvider.generateJwtToken(securityUser);
	}
}