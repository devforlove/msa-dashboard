package com.wook.top.postquery.adapter.out.service;

import com.wook.top.common.annotation.ExternalSystemAdapter;
import com.wook.top.postcommandclient.post.PostClientWrapper;
import com.wook.top.postcommandclient.post.response.PostCreateInfo;
import com.wook.top.postquery.application.port.out.CreatePostZeroPayloadPort;
import lombok.RequiredArgsConstructor;

@ExternalSystemAdapter
@RequiredArgsConstructor
public class PostZeroPayloadAdapter implements CreatePostZeroPayloadPort {

	private final PostClientWrapper postClientWrapper;

	@Override
	public PostCreateInfo getPostCreateInfo(long postId) {
		return postClientWrapper.getPostCreateInfo(postId);
	}
}
