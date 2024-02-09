package com.wook.top.postcommandclient.client;

import com.wook.top.postcommandclient.config.FeignConfig;
import com.wook.top.postcommandclient.postquery.request.PostInfoResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
		name = "demo-client",
		url = "${feign.url.post-command}",
		configuration = FeignConfig.class
)
public interface PostClient {

	@GetMapping("/v1/post/{postId}")
	ResponseEntity<PostInfoResponse> getPostInfo(
			@PathVariable Long postId
	);
}

