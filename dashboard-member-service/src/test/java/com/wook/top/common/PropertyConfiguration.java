package com.wook.top.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration
@EnableConfigurationProperties
public class PropertyConfiguration {

	@Value("${jwt.jwtSecretKey}")
	String jwtSecretKey;

	@Value("${jwt.expirationTime}")
	long expirationTime;
}
