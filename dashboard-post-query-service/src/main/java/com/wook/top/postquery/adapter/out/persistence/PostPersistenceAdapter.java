package com.wook.top.postquery.adapter.out.persistence;

import com.wook.top.common.annotation.PersistenceAdapter;
import com.wook.top.postquery.application.port.out.PostSavePort;
import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class PostPersistenceAdapter implements PostSavePort {

	private final PostDetailRepository postDetailRepository;

	@Override
	public void savePostData(Long writerId, String title, String content) {
		final PostDetail postDetail = PostDetail.of(writerId, title, content);
		postDetailRepository.save(postDetail);
	}
}
