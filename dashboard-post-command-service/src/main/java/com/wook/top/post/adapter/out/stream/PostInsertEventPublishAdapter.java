package com.wook.top.post.adapter.out.stream;

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

	@Override
	public void publish(InternalPostEvent event) {
		CompletableFuture<SendResult<String, Object>> future = kafkaTemplate.send("", "");
		future.whenComplete((result , e) -> {
			if (e == null) {

			} else {

			}
		});
	}
}
