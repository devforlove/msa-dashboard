package com.wook.top.kafkapublisher.post.event;

import com.wook.top.kafkapublisher.post.type.PostEventType;

public class InternalPostEvent {
	private Long postId;
	private Long memberId;

	private PostEventType type;

	private String attributes;
}
