package com.wook.top.postquery.adapter.in.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class PostCreateListener {

	@KafkaListener(
			topics = "post-insert-topic",
			groupId = "post-insert-group-id",
			concurrency = "3"
	)
	public void postCreateListener(ConsumerRecords<String, String> records) {
		records.forEach(record -> {
			System.out.println(record.value());
		});
	}
}
