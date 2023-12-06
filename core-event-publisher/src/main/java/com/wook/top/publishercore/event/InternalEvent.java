package com.wook.top.publishercore.event;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import java.time.LocalDateTime;
import lombok.Getter;

@Getter
@MappedSuperclass
public class InternalEvent {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long eventId;

	protected boolean isPublished;
	private LocalDateTime publishedAt;

	public void publish() {
		this.isPublished = true;
		this.publishedAt = LocalDateTime.now();
	}
}
