package com.wook.top.member.common.error;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;
import lombok.Builder;
import org.springframework.validation.FieldError;

@Builder
public class ErrorResponse {
	private int code;
	private String message;
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private List<ValidationError> errors;

	public ErrorResponse(int code, String message) {
		this.code = code;
		this.message = message;
	}

	public ErrorResponse(int code, String message, List<ValidationError> errors) {
		this.code = code;
		this.message = message;
		this.errors = errors;
	}

	@Builder
	public record ValidationError(String filed, String message) {

		public static ValidationError of(final FieldError fieldError) {
			return ValidationError.builder()
					.filed(fieldError.getField())
					.message(fieldError.getDefaultMessage())
					.build();
		}
	}
}
