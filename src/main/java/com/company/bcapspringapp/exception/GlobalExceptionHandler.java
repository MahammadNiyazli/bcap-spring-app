package com.company.bcapspringapp.exception;

import com.company.bcapspringapp.ResponseCodes;
import com.company.bcapspringapp.dto.response.base.ErrorResponse;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BaseException.class)
    public ResponseEntity<ErrorResponse> handleRuntimeException(BaseException baseException){
        baseException.printStackTrace();
        ErrorResponse errorResponse = new ErrorResponse(baseException.getMessage(), baseException.getStatusCode());
        return ResponseEntity
                .status(HttpStatusCode.valueOf(baseException.getHttpStatusCode()))
                .body(errorResponse);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception exception){
        exception.printStackTrace();
        ErrorResponse errorResponse = new ErrorResponse(ResponseCodes.INTERNAL_SERVER_ERROR.getMessage(), ResponseCodes.INTERNAL_SERVER_ERROR.getStatusCode());
        return ResponseEntity
                .status(HttpStatusCode.valueOf(ResponseCodes.INTERNAL_SERVER_ERROR.getHttpStatusCode()))
                .body(errorResponse);
    }
}
