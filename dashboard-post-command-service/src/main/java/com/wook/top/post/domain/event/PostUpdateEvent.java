package com.wook.top.post.domain.event;

import com.wook.top.post.domain.model.Post;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class PostUpdateEvent {
	private final Post post;
}
