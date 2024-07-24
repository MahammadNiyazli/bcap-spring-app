package com.company.bcapspringapp;

import lombok.Getter;
import org.hibernate.query.sql.internal.ParameterRecognizerImpl;

@Getter
public enum ResponseCodes {
    DEFAULT_SUCCESS("success", 200, 200),
    INTERNAL_SERVER_ERROR("error", 500, 500),
    CUSTOMER_REQUEST_INVALID_ERROR("Customer create request is invalid", 7894, 400),
    CUSTOMER_NOT_FOUND("Customer not found", 7894, 404);

    private final String message;
    private final Integer statusCode;
    private final Integer httpStatusCode;

    ResponseCodes(String message, Integer statusCode, Integer httpStatusCode) {
        this.message = message;
        this.statusCode = statusCode;
        this.httpStatusCode = httpStatusCode;
    }
}
