package com.wook.top.post.command.domain.model;

import com.wook.top.publishercore.event.InternalEvent;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "post_event")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class InternalPostEvent extends InternalEvent {

	private Long postId;

	@Enumerated(value = EnumType.STRING)
	private PostEventType type;

	private String attributes;

	public InternalPostEvent(Long postId, PostEventType type, String attributes, Long requestedBy) {
		this.postId = postId;
		this.type = type;
		this.attributes = attributes;
		this.isPublished = false;
		this.requestedBy = requestedBy;
	}
}
