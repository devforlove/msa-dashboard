package com.wook.top.post.command.adapter.out.persistence;

import com.wook.top.post.command.domain.InternalPostEvent;
import org.springframework.data.repository.Repository;

public interface PostEventRepository extends Repository<InternalPostEvent, Long> {
	void save(InternalPostEvent internalPostEvent);
}
