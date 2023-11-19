package com.wook.top.front.member.common.feign;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MemberFeignConfig {

	@Bean
	public MemberFeignInterceptor memberfeignInterceptor() {
		return new MemberFeignInterceptor();
	}

//	@Bean
//	public MemberFeignErrorDecoder memberDemoFeignErrorDecoder() {
//		return new MemberFeignErrorDecoder();
//	}
}
