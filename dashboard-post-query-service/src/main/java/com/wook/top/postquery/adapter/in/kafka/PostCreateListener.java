package com.wook.top.postquery.adapter.in.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wook.top.kafkapublisher.post.event.PostEvent;
import com.wook.top.postquery.application.port.in.PostCreateService;
import com.wook.top.postquery.application.port.in.PostEventDto;
import com.wook.top.webcore.error.ErrorCode;
import com.wook.top.webcore.error.exception.BusinessException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class PostCreateListener {

	private final PostCreateService postCreateService;
	private final ObjectMapper objectMapper;

	@KafkaListener(
			topics = "post-insert-topic",
			groupId = "post-insert-group-id",
			concurrency = "1"
	)
	public void postCreateListener(ConsumerRecords<String, String> records) {
		records.forEach(record -> {
			final String value = record.value();
			try {
				final PostEvent postEvent = objectMapper.readValue(value, PostEvent.class);

				final PostEventDto postEventDto = new PostEventDto(postEvent.getPostId());
				postCreateService.createPost(postEventDto);
			} catch (JsonProcessingException e) {
				throw new BusinessException(ErrorCode.PARSING_ERROR, "invalid parsing value");
			}
		});
	}
}

