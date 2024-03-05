package com.wook.top.postquery.adapter.out.persistence;

import org.springframework.data.repository.Repository;

public interface PostDetailRepository extends Repository<PostDetail, String> {
	PostDetail save(PostDetail model);
}
