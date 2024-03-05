package com.wook.top.post.command.application.service;

import com.wook.top.common.annotation.UseCase;
import com.wook.top.post.command.adapter.in.web.PostCreateResponse;
import com.wook.top.post.command.application.port.in.PostCreateCommand;
import com.wook.top.post.command.application.port.in.PostCreateUseCase;
import com.wook.top.post.command.application.port.out.MemberClientPort;
import com.wook.top.post.command.application.port.out.PostCreatePort;
import com.wook.top.post.command.domain.Post;
import com.wook.top.webcore.error.ErrorCode;
import com.wook.top.webcore.error.exception.BusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@UseCase
@RequiredArgsConstructor
public class PostCreatService implements PostCreateUseCase {

	private final PostCreatePort postCreatePort;
	private final MemberClientPort memberClientPort;

	@Transactional
	@Override
	public PostCreateResponse createPost(PostCreateCommand command) {
		boolean valid = memberClientPort.checkMemberValid(command.writerId());
		if (!valid) {
			throw new BusinessException(ErrorCode.MEMBER_NOT_VALID, "member is not valid");
		}

		Post post = Post.createPost(command.writerId(), command.title(), command.content());
		postCreatePort.savePost(post);
		return new PostCreateResponse(post.getTitle(), post.getContent());
	}
}
