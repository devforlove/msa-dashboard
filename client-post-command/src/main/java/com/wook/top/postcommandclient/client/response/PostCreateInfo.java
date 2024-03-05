package com.wook.top.postcommandclient.client.response;

public record PostCreateInfo(
		Long writerId,
		String title,
		String content
) {
}
