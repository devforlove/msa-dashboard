package com.wook.top.postcommandclient.post;

import com.wook.top.postcommandclient.post.PostClient;
import com.wook.top.postcommandclient.post.response.PostCreateInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PostClientWrapper {

	private final PostClient postClient;

	public PostCreateInfo getPostCreateInfo(long postId) {
		return postClient.getPostInfo(postId).getBody();
	}
}
