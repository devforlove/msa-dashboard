package com.wook.top.postcommand.postquery;

import com.wook.top.postcommand.postquery.request.PostInfoResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

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
