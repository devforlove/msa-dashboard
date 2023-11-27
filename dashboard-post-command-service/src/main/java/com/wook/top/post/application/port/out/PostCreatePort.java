package com.wook.top.post.application.port.out;

import com.wook.top.post.domain.model.Post;

public interface PostCreatePort {
	void savePost(Post post);
}
