package com.wook.top.post.application.port.in;

public record PostCreateCommand(
		Long writerId,
		String title,
		String content
) {

}
