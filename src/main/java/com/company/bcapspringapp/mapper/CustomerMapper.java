package com.company.bcapspringapp.mapper;

import com.company.bcapspringapp.dao.entity.Customer;
import com.company.bcapspringapp.dto.request.CustomerRequest;
import com.company.bcapspringapp.dto.response.CustomerResponse;

import java.sql.Timestamp;
import java.time.Instant;

public class CustomerMapper {
    public static CustomerResponse customerResponse(Customer customer){
        return CustomerResponse.builder()
                .name(customer.getName())
                .surname(customer.getSurname())
                .email(customer.getEmail())
                .createdAt(customer.getCreatedAt())
                .id(customer.getId())
                .isActive(customer.getIsActive())
                .updatedAt(customer.getUpdatedAt())
                .build();
    }

    public static Customer toEntity(CustomerRequest customerRequest){
        return Customer
                .builder()
                .name(customerRequest.getName())
                .surname(customerRequest.getSurname())
                .email(customerRequest.getEmail())
                .isActive(true)
                .createdAt(Timestamp.from(Instant.now()))
                .build();
    }
}
