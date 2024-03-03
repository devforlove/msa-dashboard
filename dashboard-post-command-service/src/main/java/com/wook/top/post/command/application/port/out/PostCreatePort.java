package com.wook.top.post.command.application.port.out;

import com.wook.top.post.command.domain.model.Post;

public interface PostCreatePort {
	void savePost(Post post);
}
