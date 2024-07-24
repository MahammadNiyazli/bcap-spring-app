package com.company.bcapspringapp.dto.response;

import com.company.bcapspringapp.dao.entity.Customer;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Builder
public class CardResponse {
    private Long id;
    private String name;
    private String cardNumber;
    private String pin;
    private String ccyCode;
    private String holderName;
    private Boolean isActive;
    private Timestamp expireDate;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
