package com.wook.top.post.adapter.out.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wook.top.common.annotation.ExternalSystemAdapter;
import com.wook.top.post.application.port.out.PostInsertEventPublishPort;
import com.wook.top.post.domain.model.InternalPostEvent;
import java.util.concurrent.CompletableFuture;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;

@Slf4j
@ExternalSystemAdapter
@RequiredArgsConstructor
public class PostInsertEventPublishAdapter implements PostInsertEventPublishPort {

	private final KafkaTemplate<String, Object> kafkaTemplate;
	private final ObjectMapper objectMapper;
	private static final String TOPIC = "post-insert-topic";

	@Override
	public void publish(InternalPostEvent event) {
		CompletableFuture<SendResult<String, Object>> future = null;
		try {
			future = kafkaTemplate.send(TOPIC, objectMapper.writeValueAsString(event));
		} catch (JsonProcessingException e) {
			throw new IllegalArgumentException(e);
		}

		future.whenComplete((result , e) -> {
			if (e == null) {
				log.info("produced message topic");
			} else {
				log.error("Error occurred while producing message: {}", e.getMessage());
			}
		});
	}
}
