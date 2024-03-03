package com.wook.top.post.application.service;

import com.wook.top.kafkapublisher.post.event.PostEvent;
import com.wook.top.kafkapublisher.post.type.PostEventType;
import com.wook.top.post.application.port.out.PostInsertEventPublishPort;
import com.wook.top.post.domain.model.InternalPostEvent;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class PostInternalEventHandler {

	private final PostInsertEventPublishPort postInsertEventPublishPort;
	private final EntityManager em;

	@TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
	public void handle(InternalPostEvent event) {
		publish(event);
		try {

			postInsertEventPublishPort.publish(
					PostEvent.of(event.getPostId(), PostEventType.INSERT)
			);
		} catch (Exception e) {
			log.warn("Internal Cover event publish failed {}.", e.getMessage());
		}
	}

	private void publish(InternalPostEvent event) {
		em.merge(event).publish();
	}
}
