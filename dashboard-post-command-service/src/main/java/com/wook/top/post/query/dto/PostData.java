package com.wook.top.post.query.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "post")
@NoArgsConstructor
public class PostData {

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
	private Long likeCount;

	public PostData(Long writerId, String title, String content, Long likeCount) {
		this.writerId = writerId;
		this.title = title;
		this.content = content;
		this.likeCount = likeCount;
	}
}
