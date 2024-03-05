package com.wook.top.postquery.application.service;

import com.wook.top.common.annotation.UseCase;
import com.wook.top.postcommandclient.client.response.PostCreateInfo;
import com.wook.top.postquery.application.port.in.PostEventDto;
import com.wook.top.postquery.application.port.out.PostCreateZeroPayloadPort;
import com.wook.top.postquery.application.port.out.PostSavePort;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class PostCreateService implements com.wook.top.postquery.application.port.in.PostCreateService {

	private final PostCreateZeroPayloadPort postCreateZeroPayloadPort;
	private final PostSavePort postSavePort;

	@Override
	public void createPost(PostEventDto dto) {
		PostCreateInfo postCreateInfo = postCreateZeroPayloadPort.getPostCreateInfo(dto.postId());
		postSavePort.savePostData(postCreateInfo.writerId(), postCreateInfo.title(), postCreateInfo.content());
	}
}
