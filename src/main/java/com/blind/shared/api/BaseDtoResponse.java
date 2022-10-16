package com.blind.shared.api;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BaseDtoResponse {
    String message = null;

    Integer statusCode = null;

    public BaseDtoResponse(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public BaseDtoResponse(Integer statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

    public static BaseDtoResponse of(Integer statusCode, String message) {
        BaseDtoResponse baseResponse = new BaseDtoResponse();
        baseResponse.statusCode = statusCode;
        baseResponse.message = message;
        return baseResponse;
    }
}
