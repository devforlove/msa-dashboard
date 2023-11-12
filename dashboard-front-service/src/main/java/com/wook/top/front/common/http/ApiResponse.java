package com.wook.top.front.common.http;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class ApiResponse<T> {
	private final T result;
	private final int status;

	@Builder
	public ApiResponse(T result, int status) {
		this.result = result;
		this.status = status;
	}

	public ApiResponse(int status) {
		this.status = status;
		this.result = null;
	}
}
