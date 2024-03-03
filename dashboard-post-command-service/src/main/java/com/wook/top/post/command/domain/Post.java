package com.wook.top.post.command.domain;

import com.wook.top.post.command.adapter.out.persistence.PostInsertEvent;
import com.wook.top.post.command.adapter.out.persistence.PostUpdateEvent;
import com.wook.top.post.command.domain.converter.PostLikeCountConverter;
import com.wook.top.publishercore.Events;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PostUpdate;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "post")
@NoArgsConstructor
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "member_id")
	private Long postId;

	@Column(name = "post_writer_id")
	private Long writerId;

	@Column(name = "post_title")
	private String title;

	@Column(name = "post_content")
	private String content;

	@Column(name = "post_like_count")
	@Convert(converter = PostLikeCountConverter.class)
	private LikeCount likeCount;

	public Post(Long writerId, String title, String content, LikeCount likeCount) {
		this.writerId = writerId;
		this.title = title;
		this.content = content;
		this.likeCount = likeCount;
	}

	public static Post createPost(Long writerId, String title, String text) {
		LikeCount likeCount = new LikeCount(0);
		return new Post(writerId, title, text, likeCount);
	}

	@PostPersist
	private void onPostPersist() {
		Events.raise(new PostInsertEvent(this));
	}

	@PostUpdate
	private void onPostUpdate() {
		Events.raise(new PostUpdateEvent(this));
	}
}
