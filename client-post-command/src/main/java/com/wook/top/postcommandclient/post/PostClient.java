package com.wook.top.postcommandclient.post;

import com.wook.top.postcommandclient.config.FeignConfig;
import com.wook.top.postcommandclient.post.response.PostCreateInfo;
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

	@GetMapping("/v1/post/{postId}/info/create")
	ResponseEntity<PostCreateInfo> getPostInfo(
			@PathVariable long postId
	);
}

