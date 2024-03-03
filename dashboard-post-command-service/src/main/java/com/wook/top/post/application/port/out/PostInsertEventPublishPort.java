package com.wook.top.post.application.port.out;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.wook.top.kafkapublisher.post.event.PostEvent;
import com.wook.top.post.domain.model.InternalPostEvent;

public interface PostInsertEventPublishPort {
	void publish(PostEvent event);
}
