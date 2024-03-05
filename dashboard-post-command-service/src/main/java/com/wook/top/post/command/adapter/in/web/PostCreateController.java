package com.wook.top.post.command.adapter.in.web;

import com.wook.top.common.annotation.WebAdapter;
import com.wook.top.post.command.application.port.in.PostCreateCommand;
import com.wook.top.post.command.application.port.in.PostCreateUseCase;
import com.wook.top.webcore.security.SecurityUser;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@WebAdapter
@RequestMapping("/post/v1")
@RequiredArgsConstructor
public class PostCreateController {

	private final PostCreateUseCase postCreateUseCase;

	@PostMapping("/post/me")
	public ResponseEntity<PostCreateResponse> createPost(@RequestBody PostCreateRequest request, @AuthenticationPrincipal SecurityUser securityUser) {

		final PostCreateCommand command = new PostCreateCommand(securityUser.getMemberId(), request.title(), request.content());
		return new ResponseEntity<>(postCreateUseCase.createPost(command), HttpStatus.CREATED);
	}
}
