package com.wook.top.post.command.adapter.out.persistence;

import com.wook.top.common.annotation.PersistenceAdapter;
import com.wook.top.post.command.application.port.out.PostCreatePort;
import com.wook.top.post.command.domain.model.Post;
import com.wook.top.post.command.domain.repository.PostRepository;
import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class PostCreateAdapter implements PostCreatePort {

	private final PostRepository postRepository;

	@Override
	public void savePost(Post post) {
		postRepository.save(post);
	}
}
