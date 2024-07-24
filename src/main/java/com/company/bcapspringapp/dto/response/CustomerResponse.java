package com.company.bcapspringapp.dto.response;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.sql.Timestamp;
@Builder
@Data
public class CustomerResponse {
    private Long id;
    private String name;
    private String surname;
    private String email;
    private Boolean isActive;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
