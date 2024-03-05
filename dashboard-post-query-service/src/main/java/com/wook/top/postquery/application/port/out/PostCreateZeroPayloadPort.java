package com.wook.top.postquery.application.port.out;

import com.wook.top.postcommandclient.client.response.PostCreateInfo;

public interface PostCreateZeroPayloadPort {

	PostCreateInfo getPostCreateInfo(long postId);
}
