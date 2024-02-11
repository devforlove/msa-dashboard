package com.wook.top.post.domain.repository;

import com.wook.top.post.domain.model.Post;
import java.util.Optional;
import org.springframework.data.repository.Repository;

public interface PostRepository extends Repository<Post, Long> {
	void save(Post post);
	Optional<Post> findById(Long id);
}
