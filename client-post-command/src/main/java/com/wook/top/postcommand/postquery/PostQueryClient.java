package com.wook.top.postcommand.postquery;

import com.wook.top.postcommand.postquery.PostClientErrorDecoder.PostInfoResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
		name = "member-client",
		url = "${feign.url.post-command}",
		configuration = PostQueryFeignConfig.class
)
public interface PostQueryClient {

	@GetMapping("/v1/post/{postId}")
	ResponseEntity<PostInfoResponse> getPostInfo(
		@PathVariable Long postId
	);
}
