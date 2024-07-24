package com.company.bcapspringapp.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class CustomerRequest {
    @NotNull
    private String name;
    @NotNull
    private String surname;
    @NotNull
    private String email;
}
