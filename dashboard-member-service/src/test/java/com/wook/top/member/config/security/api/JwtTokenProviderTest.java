package com.wook.top.member.config.security.api;

import static org.assertj.core.api.Assertions.assertThat;

import com.wook.top.testFixture.SecurityUserFixture;
import com.wook.top.webcore.security.JwtTokenProvider;
import com.wook.top.webcore.security.SecurityUser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;

@EnableConfigurationProperties
@SpringBootTest(classes = JwtTokenProvider.class)
@DisplayName("JwtTokenProvider 테스트")
class JwtTokenProviderTest {
	JwtTokenProvider jwtTokenProvider;
	SecurityUser securityUser;

	@Value("${jwt.jwtSecretKey}")
	private String jwtSecretKey;

	@Value("${jwt.expirationTime}")
	private long expireTime;

	@BeforeEach
	void setup() {
		securityUser = SecurityUserFixture.MEMBER.getSecurityUser();
		jwtTokenProvider = new JwtTokenProvider(jwtSecretKey, expireTime);
	}

	@DisplayName("토큰 생성하고 SecurityUser 반환")
	@Test
	void withSecurityUser_GenerateToken() {
		// given
		String token = jwtTokenProvider.generateJwtToken(securityUser);

		// when
		SecurityUser securityUser = jwtTokenProvider.getSecurityUser(token);

		// then
		assertThat(securityUser.getMemberId()).isEqualTo(this.securityUser.getMemberId());
		assertThat(securityUser.getEmail()).isEqualTo(this.securityUser.getEmail());
		assertThat(securityUser.getUsername()).isEqualTo(this.securityUser.getUsername());
		assertThat(securityUser.getPassword()).isEqualTo(this.securityUser.getPassword());
		assertThat(securityUser.getAuthorities()).isEqualTo(this.securityUser.getAuthorities());
	}

	@DisplayName("토큰 값이 달라지면 false 반환")
	@Test
	void withInvalidToken_ReturnFalse() {
		// given
		String token = jwtTokenProvider.generateJwtToken(securityUser);
		token += "5$#&a!dfe";

		// when
		boolean result = jwtTokenProvider.validateToken(token);

		// then
		assertThat(result).isFalse();
	}

	@DisplayName("토큰 값이 유효하면 true 반환")
	@Test
	void withValidToken_ReturnTrue() {
		// given
		String token = jwtTokenProvider.generateJwtToken(securityUser);

		// when
		boolean result = jwtTokenProvider.validateToken(token);

		// then
		assertThat(result).isTrue();
	}
}