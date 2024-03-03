package com.wook.top.post.command.adapter.out.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wook.top.common.annotation.ExternalSystemAdapter;
import com.wook.top.kafkapublisher.post.event.PostEvent;
import com.wook.top.post.command.application.port.out.PostInsertEventPublishPort;
import com.wook.top.webcore.error.ErrorCode;
import com.wook.top.webcore.error.exception.BusinessException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;

@Slf4j
@ExternalSystemAdapter
@RequiredArgsConstructor
public class PostInsertEventPublishAdapter implements PostInsertEventPublishPort {

	private final KafkaTemplate<String, Object> kafkaTemplate;
	private final ObjectMapper objectMapper;
	private static final String TOPIC = "post-insert-topic";

	@Override
	public void publish(PostEvent event) {
		try {
			kafkaTemplate.send(TOPIC, objectMapper.writeValueAsString(event)).whenComplete((result , e) -> {
				if (e == null) {
					log.info("produced message topic");
				} else {
					log.error("Error occurred while producing message: {}", e.getMessage());
				}
			});
		} catch (JsonProcessingException e) {
			throw new BusinessException(ErrorCode.PARSING_ERROR, "invalid parsing data");
		}
	}
}
