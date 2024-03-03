package com.wook.top.post.command.application.port.out;

import com.wook.top.kafkapublisher.post.event.PostEvent;

public interface PostInsertEventPublishPort {
	void publish(PostEvent event);
}
