package com.wook.top.post.command.application.port.in;

public interface PostCreateUseCase {
	PostCreateInfo createPost(PostCreateCommand command);
}
