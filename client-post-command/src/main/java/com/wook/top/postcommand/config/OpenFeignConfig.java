package com.wook.top.postcommand.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients("com.wook.top.front.member.common.feign")
public class OpenFeignConfig {

}
