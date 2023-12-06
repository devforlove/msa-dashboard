package com.wook.top.post.adapter.out.stream;

import com.wook.top.common.annotation.PersistenceAdapter;
import com.wook.top.post.application.port.out.PostInsertEventPublishPort;
import com.wook.top.post.domain.model.InternalPostEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@PersistenceAdapter
@RequiredArgsConstructor
public class PostInsertEventPublishAdapter implements PostInsertEventPublishPort {

	@Override
	public void publish(InternalPostEvent event) {

	}
}
