package com.wook.top.postcommandclient.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients("com.wook.top.postcommandclient.post")
public class CommonConfig {

}
