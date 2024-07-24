package com.company.bcapspringapp.exception;

import com.company.bcapspringapp.ResponseCodes;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import javax.management.RuntimeOperationsException;

@AllArgsConstructor
@Getter
public class BaseException extends RuntimeException {
    private String message;
    private Integer statusCode;
    private Integer httpStatusCode;

    public static BaseException of(ResponseCodes responseCodes){
        return new BaseException(responseCodes.getMessage(),
                responseCodes.getStatusCode(),
                responseCodes.getHttpStatusCode());
    }
}
