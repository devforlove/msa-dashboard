package com.wook.top.post.application.port.in;

public interface PostCreateUseCase {
	PostCreateInfo createPost(PostCreateCommand command);
}
