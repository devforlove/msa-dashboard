package com.wook.top.post.command.adapter.out.persistence;

import com.wook.top.post.command.domain.Post;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class PostInsertEvent {
	private final Post post;
}
