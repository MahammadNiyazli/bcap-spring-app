package com.company.bcapspringapp.controller;

import com.company.bcapspringapp.dto.request.CustomerRequest;
import com.company.bcapspringapp.dto.response.CustomerResponse;
import com.company.bcapspringapp.dto.response.base.SuccessResponse;
import com.company.bcapspringapp.mapper.CustomerMapper;
import com.company.bcapspringapp.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/customers")
public class CustomerController { //

    private final CustomerService customerService;

    @GetMapping
    public List<CustomerResponse> getAllCustomers(){
        List<CustomerResponse> customerResponses = customerService.getAllCustomers();
        System.err.println(customerResponses);
        return customerResponses;
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public SuccessResponse<Object> createCustomer(@RequestBody @Valid CustomerRequest customerRequest){
        return customerService.createCustomer(customerRequest);
    }

    @GetMapping("/{id}")
    public CustomerResponse getCustomerById(@PathVariable Long id){
         return customerService.getCustomerById(id);
    }

}
