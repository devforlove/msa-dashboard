package com.wook.top.member.config.security;


import com.wook.top.member.config.security.api.AuthenticationFilter;
import com.wook.top.webcore.security.JwtAuthorizationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {
	private final AuthenticationFilter authenticationFilter;
	private final JwtAuthorizationFilter jwtAuthorizationFilter;

	@Bean
	public SecurityFilterChain securityFilterChain(
			HttpSecurity http
	) throws Exception {

		return http
				.authorizeHttpRequests(auth -> auth
						.requestMatchers("/member/v1/**").permitAll()
						.requestMatchers("/member/v1/me").hasRole("MEMBER")
						.anyRequest().authenticated()
				)
				.formLogin(AbstractHttpConfigurer::disable)
				.csrf(AbstractHttpConfigurer::disable)
				.addFilterBefore(authenticationFilter, UsernamePasswordAuthenticationFilter.class)
				.addFilterAfter(jwtAuthorizationFilter, UsernamePasswordAuthenticationFilter.class)
				.sessionManagement(s -> s.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.build();
	}

	@Bean
	@Order(0)
	public SecurityFilterChain resources(HttpSecurity http) throws Exception {
		return http
				.securityMatcher("/swagger-ui/**",
						"/v3/api-docs/**")
				.authorizeHttpRequests(auth -> auth
						.anyRequest().permitAll()
				)
				.build();
	}
}
