package com.wook.top.postquery.application.port.out;

import com.wook.top.postcommandclient.post.response.PostCreateInfo;

public interface CreatePostZeroPayloadPort {

	PostCreateInfo getPostCreateInfo(long postId);
}
