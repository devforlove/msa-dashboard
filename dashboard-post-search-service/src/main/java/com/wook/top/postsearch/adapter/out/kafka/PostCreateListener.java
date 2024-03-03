package com.wook.top.postsearch.adapter.out.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;

public class PostCreateListener {

	@KafkaListener(
			topics = "post-insert-topic",
			groupId = "post-search-group-id",
			concurrency = "1"
	)
	public void postCreateListener(ConsumerRecord<String, String> record) {
		record.value();
	}
}
