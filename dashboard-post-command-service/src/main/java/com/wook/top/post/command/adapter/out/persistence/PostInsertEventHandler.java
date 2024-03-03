package com.wook.top.post.command.adapter.out.persistence;

import com.wook.top.post.command.domain.InternalPostEvent;
import com.wook.top.post.command.domain.Post;
import com.wook.top.post.command.domain.PostEventType;
import com.wook.top.publishercore.Events;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Service
@RequiredArgsConstructor
public class PostInsertEventHandler {

	private final PostEventRepository postEventRepository;

	@TransactionalEventListener(phase = TransactionPhase.BEFORE_COMMIT)
	public void handle(PostInsertEvent event) {
		Post post = event.getPost();
		InternalPostEvent coverEvent = new InternalPostEvent(
				post.getPostId(),
				PostEventType.INSERT,
				post.getTitle(),
				post.getWriterId()
		);
		postEventRepository.save(coverEvent);
		Events.raise(coverEvent);
	}
}
