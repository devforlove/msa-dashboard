package com.wook.top.front.common.http;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ApiResponse<T> {
	private final T result;
	private final int status;

	@Builder
	public ApiResponse(T result, HttpStatus status) {
		this.result = result;
		this.status = status.value();
	}

	public ApiResponse(HttpStatus status) {
		this.status = status.value();
		this.result = null;
	}
}
