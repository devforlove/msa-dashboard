package com.wook.top.post.command.application.port.in;

import com.wook.top.post.command.adapter.in.web.PostCreateResponse;

public interface PostCreateUseCase {
	PostCreateResponse createPost(PostCreateCommand command);
}
