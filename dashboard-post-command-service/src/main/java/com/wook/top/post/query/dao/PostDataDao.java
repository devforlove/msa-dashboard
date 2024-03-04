package com.wook.top.post.query.dao;

import com.wook.top.post.query.dto.PostData;
import org.springframework.data.repository.Repository;

public interface PostDataDao extends Repository<PostData, Long> {
	PostData findByPostId(long postId);
}
