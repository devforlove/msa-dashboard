package com.wook.top.postquery.config;

import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients("com.wook.top.front.member.common.feign")
public class OpenFeignConfig {

}
