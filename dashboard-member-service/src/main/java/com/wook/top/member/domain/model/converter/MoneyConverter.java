package com.wook.top.member.domain.model.converter;

import com.wook.top.member.domain.model.Score;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class MoneyConverter implements AttributeConverter<Score, Integer> {

	@Override
	public Integer convertToDatabaseColumn(Score attribute) {
		return null;
	}

	@Override
	public Score convertToEntityAttribute(Integer dbData) {
		return null;
	}
}
