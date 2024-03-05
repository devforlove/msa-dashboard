package com.wook.top.postquery.adapter.out.service;

import com.wook.top.common.annotation.ExternalSystemAdapter;
import com.wook.top.postcommandclient.client.PostInfoClientWrapper;
import com.wook.top.postcommandclient.client.response.PostCreateInfo;
import com.wook.top.postquery.application.port.out.PostCreateZeroPayloadPort;
import lombok.RequiredArgsConstructor;

@ExternalSystemAdapter
@RequiredArgsConstructor
public class PostCreateZeroPayloadAdapter implements PostCreateZeroPayloadPort {

	private final PostInfoClientWrapper postClientWrapper;

	@Override
	public PostCreateInfo getPostCreateInfo(long postId) {
		return postClientWrapper.getPostCreateInfo(postId);
	}
}
