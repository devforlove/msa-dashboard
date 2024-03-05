package com.wook.top.postcommandclient.client;

import com.wook.top.postcommandclient.client.response.PostCreateInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PostInfoClientWrapper {

	private final PostInfoClient postClient;

	public PostCreateInfo getPostCreateInfo(long postId) {
		return postClient.getPostInfo(postId).getBody();
	}
}
