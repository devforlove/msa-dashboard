package com.wook.top.member.domain.model.converter;

import com.wook.top.member.domain.model.Score;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class ScoreConverter implements AttributeConverter<Score, Integer> {

	@Override
	public Integer convertToDatabaseColumn(Score score) {
		return score == null ? null : score.getScorePoint();
	}

	@Override
	public Score convertToEntityAttribute(Integer value) {
		return null;
	}
}
