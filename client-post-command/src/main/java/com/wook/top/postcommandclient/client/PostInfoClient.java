package com.wook.top.postcommandclient.client;

import com.wook.top.postcommandclient.config.PostCommandFeignConfig;
import com.wook.top.postcommandclient.client.response.PostCreateInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
		name = "postCommandClient",
		url = "${feign.url.post-command:default}",
		configuration = PostCommandFeignConfig.class
)
public interface PostInfoClient {

	@GetMapping("/v1/post/{postId}/info/create")
	ResponseEntity<PostCreateInfo> getPostInfo(
			@PathVariable long postId
	);
}

