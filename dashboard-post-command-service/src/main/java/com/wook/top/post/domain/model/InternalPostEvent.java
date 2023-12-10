package com.wook.top.post.domain.model;

import com.wook.top.publishercore.event.InternalEvent;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.kafka.common.serialization.Serializer;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(name = "post_event")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class InternalPostEvent extends InternalEvent {

	private Long postId;
	@Enumerated(value = EnumType.STRING)
	private PostEventType type;
	private String attributes;
	@CreatedDate
	private LocalDateTime createdAt;
	private String requestedBy;

	public InternalPostEvent(Long postId, PostEventType type, String attributes) {
		this.postId = postId;
		this.type = type;
		this.attributes = attributes;
		this.isPublished = false;
	}
}
