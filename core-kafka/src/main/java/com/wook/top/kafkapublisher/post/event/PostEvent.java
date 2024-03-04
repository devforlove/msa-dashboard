package com.wook.top.kafkapublisher.post.event;

import com.wook.top.kafkapublisher.post.type.PostEventType;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostEvent {
	private Long postId;
	private PostEventType eventType;

	public static PostEvent of(Long postId, PostEventType type) {
		PostEvent postEvent = new PostEvent();
		postEvent.postId = postId;
		postEvent.eventType = type;

		return postEvent;
	}
}
