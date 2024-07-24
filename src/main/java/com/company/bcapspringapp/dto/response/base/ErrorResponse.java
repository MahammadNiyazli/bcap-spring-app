package com.company.bcapspringapp.dto.response.base;

import lombok.*;

@Getter
@Setter
public class ErrorResponse extends BaseResponse<Object>{
    public ErrorResponse(String message, Integer statusCode) {
        super(message, statusCode);
    }
}
