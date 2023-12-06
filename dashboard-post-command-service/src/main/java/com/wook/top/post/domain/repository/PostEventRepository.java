package com.wook.top.post.domain.repository;

import com.wook.top.post.domain.model.InternalPostEvent;
import org.springframework.data.repository.Repository;

public interface PostEventRepository extends Repository<InternalPostEvent, Long> {

}
