package com.wook.top.postquery.adapter.in.kafka;

import com.wook.top.postquery.application.port.in.PostCreateUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class PostCreateListener {

	private final PostCreateUseCase postCreateUseCase;

	@KafkaListener(
			topics = "post-insert-topic",
			groupId = "post-insert-group-id",
			concurrency = "1"
	)
	public void postCreateListener(ConsumerRecords<String, String> records) {
		records.forEach(record -> {
			String value = record.value();

		});
	}
}

