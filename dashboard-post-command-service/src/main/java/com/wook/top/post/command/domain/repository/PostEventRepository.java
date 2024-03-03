package com.wook.top.post.command.domain.repository;

import com.wook.top.post.command.domain.model.InternalPostEvent;
import org.springframework.data.repository.Repository;

public interface PostEventRepository extends Repository<InternalPostEvent, Long> {
	void save(InternalPostEvent internalPostEvent);
}
