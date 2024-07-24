package com.company.bcapspringapp.dto.response.base;

import com.company.bcapspringapp.ResponseCodes;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.SuperBuilder;
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class SuccessResponse<T> extends BaseResponse<T>{
    private T data;

    public static <R> SuccessResponse<R> createBaseResponse(R data, ResponseCodes responseCodes){
        return SuccessResponse
                .<R>builder()
                .statusCode(responseCodes.getStatusCode())
                .message(responseCodes.getMessage())
                .data(data)
                .build();
    }
}
