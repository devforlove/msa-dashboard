package com.wook.top.post.adapter.out.persistence;

import com.wook.top.common.annotation.PersistenceAdapter;
import com.wook.top.post.application.port.out.PostCreatePort;
import com.wook.top.post.domain.model.Post;
import com.wook.top.post.domain.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@PersistenceAdapter
@RequiredArgsConstructor
public class PostCreateAdapter implements PostCreatePort {

	private final PostRepository postRepository;

	@Override
	public void savePost(Post post) {
		postRepository.save(post);
	}
}
