package com.wook.top.memberclient.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients("com.wook.top.memberclient.client")
public class CommonConfig {

}
