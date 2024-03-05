package com.wook.top.postcommandclient.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients("com.wook.top.postcommandclient.client")
public class PostCommandClientConfig {

}
