package com.wook.top.member.config.security.api;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wook.top.webcore.security.JwtTokenProvider;
import com.wook.top.webcore.security.SecurityUser;
import com.wook.top.webcore.security.TokenResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AuthenticationSuccessHandlerImpl implements AuthenticationSuccessHandler {
	private final ObjectMapper objectMapper;
	private final JwtTokenProvider jwtTokenProvider;

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
		SecurityUser securityUser = (SecurityUser) authentication.getPrincipal();

		String token = jwtTokenProvider.generateJwtToken(securityUser);
		TokenResponse tokenResponse = new TokenResponse(token);

		response.setStatus(HttpStatus.OK.value());
		response.setContentType(APPLICATION_JSON_VALUE);
		objectMapper.writeValue(response.getWriter(), tokenResponse);
	}
}
