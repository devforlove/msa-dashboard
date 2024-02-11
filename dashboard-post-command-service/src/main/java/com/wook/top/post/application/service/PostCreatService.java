package com.wook.top.post.application.service;

import com.wook.top.common.annotation.UseCase;
import com.wook.top.post.adapter.out.persistence.PostCreateAdapter;
import com.wook.top.post.application.port.in.PostCreateCommand;
import com.wook.top.post.application.port.in.PostCreateInfo;
import com.wook.top.post.application.port.in.PostCreateUseCase;
import com.wook.top.post.application.port.out.PostCreatePort;
import com.wook.top.post.domain.model.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@UseCase
@RequiredArgsConstructor
public class PostCreatService implements PostCreateUseCase {

	private final PostCreatePort postCreatePort;

	@Transactional
	@Override
	public PostCreateInfo createPost(PostCreateCommand command) {
		// member에 존재?

		Post post = Post.createPost(command.writerId(), command.title(), command.content());
		postCreatePort.savePost(post);
		return new PostCreateInfo(post.getTitle(), post.getContent());
	}
}
