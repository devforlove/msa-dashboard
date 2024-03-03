package com.wook.top.post.command.domain.event;

import com.wook.top.post.command.domain.model.Post;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class PostUpdateEvent {
	private final Post post;
}
