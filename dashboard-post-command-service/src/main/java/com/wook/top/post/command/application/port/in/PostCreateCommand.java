package com.wook.top.post.command.application.port.in;

public record PostCreateCommand(
		Long writerId,
		String title,
		String content
) {

}
