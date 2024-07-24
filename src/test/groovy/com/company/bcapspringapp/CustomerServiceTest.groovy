package com.company.bcapspringapp

import com.company.bcapspringapp.dao.entity.Customer
import com.company.bcapspringapp.dao.repository.CustomerRepository
import com.company.bcapspringapp.dto.response.CustomerResponse
import com.company.bcapspringapp.exception.BaseException
import com.company.bcapspringapp.mapper.CustomerMapper
import com.company.bcapspringapp.service.CustomerService
import io.github.benas.randombeans.EnhancedRandomBuilder
import io.github.benas.randombeans.api.EnhancedRandom
import spock.lang.Specification

class CustomerServiceTest extends Specification {
    private CustomerRepository customerRepository
    private CustomerService customerService
    private EnhancedRandom random = EnhancedRandomBuilder.aNewEnhancedRandom()

    def setup() {
        customerRepository = Mock()
        customerService = new CustomerService(customerRepository)
    }

    def "getCustomerById success case"() {
        given:
        def id = random.nextObject(Long)
        def entity = random.nextObject(Customer)

        when:
        CustomerResponse customerResponse = customerService.getCustomerById(id)

        then:
        1 * customerRepository.findById(id) >> Optional.of(entity)
        customerResponse.id == entity.id
        customerResponse.email == entity.email
        customerResponse.createdAt == entity.createdAt
        customerResponse.name == entity.name;
        customerResponse.surname == entity.surname
    }


    def "getCustomerById not found case"() {
        given:
        def id = random.nextObject(Long)

        when:
         customerService.getCustomerById(id)

        then:
        1 * customerRepository.findById(id) >> Optional.empty()
        BaseException exception = thrown();
        exception.httpStatusCode == 404;
        exception.statusCode == 7894; // test coverage
    }

}
