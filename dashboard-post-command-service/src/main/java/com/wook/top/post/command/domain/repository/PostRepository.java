package com.wook.top.post.command.domain.repository;

import com.wook.top.post.command.domain.model.Post;
import java.util.List;
import org.springframework.data.repository.Repository;

public interface PostRepository extends Repository<Post, Long> {
	void save(Post post);
	List<Post> findByWriterId(Long id);
}
