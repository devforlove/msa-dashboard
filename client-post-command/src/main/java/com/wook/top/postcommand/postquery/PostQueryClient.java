package com.wook.top.postcommand.postquery;

import com.wook.top.postcommandclient.config.FeignConfig;
import com.wook.top.postcommandclient.postquery.response.PostInfoResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
		name = "member-client",
		url = "${feign.url.post-command}",
		configuration = FeignConfig.class
)
public interface PostQueryClient {

	@GetMapping("/v1/post/{postId}")
	ResponseEntity<PostInfoResponse> getPostInfo(
		@PathVariable Long postId
	);
}
