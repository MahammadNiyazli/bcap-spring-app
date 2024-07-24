package com.company.bcapspringapp.service;

import com.company.bcapspringapp.ResponseCodes;
import com.company.bcapspringapp.dao.entity.Customer;
import com.company.bcapspringapp.dao.repository.CustomerRepository;
import com.company.bcapspringapp.dto.request.CustomerRequest;
import com.company.bcapspringapp.dto.response.CustomerResponse;
import com.company.bcapspringapp.dto.response.base.SuccessResponse;
import com.company.bcapspringapp.exception.BaseException;
import com.company.bcapspringapp.mapper.CustomerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;

    public List<CustomerResponse> getAllCustomers(){
        List<Customer> customerList = customerRepository.findAll();
        return customerList
                .stream()
                .map(CustomerMapper::customerResponse)
                .toList();
    }

    public CustomerResponse getCustomerById(Long id){
        return customerRepository
                .findById(id)
                .map(CustomerMapper::customerResponse)
                .orElseThrow(()->BaseException.of(ResponseCodes.CUSTOMER_NOT_FOUND));
    }

    public SuccessResponse<Object> createCustomer(CustomerRequest customerRequest){
        Customer customer = CustomerMapper.toEntity(customerRequest);
        customerRepository.save(customer);
        return SuccessResponse.createBaseResponse(null, ResponseCodes.DEFAULT_SUCCESS);
    }

}
