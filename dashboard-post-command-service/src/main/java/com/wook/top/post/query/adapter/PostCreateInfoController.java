package com.wook.top.post.query.adapter;

import com.wook.top.common.annotation.WebAdapter;
import com.wook.top.post.command.adapter.in.web.request.PostCreateRequest;
import com.wook.top.post.command.application.port.in.PostCreateInfo;
import com.wook.top.webcore.security.SecurityUser;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@WebAdapter
@RequestMapping("/post/v1")
@RequiredArgsConstructor
public class PostCreateInfoController {

	@PostMapping("post/{postId}/info/create")
	public ResponseEntity<PostCreateInfo> getPostCreateInfo(@PathVariable long postId) {

		return null;
	}
}
