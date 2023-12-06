package com.wook.top.publishercore.config;

import com.wook.top.publishercore.Events;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class EventConfig {

	private final ApplicationContext applicationContext;

	@Bean
	public InitializingBean eventInitializer() {
		return () -> Events.setPublisher(applicationContext);
	}
}
