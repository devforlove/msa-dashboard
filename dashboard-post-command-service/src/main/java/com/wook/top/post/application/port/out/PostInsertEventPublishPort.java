package com.wook.top.post.application.port.out;

import com.wook.top.post.domain.model.InternalPostEvent;

public interface PostInsertEventPublishPort {
	void publish(InternalPostEvent event);
}
