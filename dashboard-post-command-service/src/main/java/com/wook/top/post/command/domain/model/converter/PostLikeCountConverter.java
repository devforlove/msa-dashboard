package com.wook.top.post.command.domain.model.converter;

import com.wook.top.post.command.domain.model.LikeCount;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class PostLikeCountConverter implements AttributeConverter<LikeCount, Integer> {

	@Override
	public Integer convertToDatabaseColumn(LikeCount likeCount) {
		return likeCount == null ? null : likeCount.getLikeCount();
	}

	@Override
	public LikeCount convertToEntityAttribute(Integer value) {
		return new LikeCount(value);
	}
}
