package com.company.bcapspringapp.dao.repository;

import com.company.bcapspringapp.dao.entity.Customer;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Query(value = "select c \n" +
            "from Customer c \n" +
            "         join fetch c.cardList")
    List<Customer> findAllWithCardsNativeQuery();

    @EntityGraph(type = EntityGraph.EntityGraphType.LOAD, value = "customer_entity_graph")
    List<Customer> findAll();

//    @EntityGraph(attributePaths = {"cardList"}) // ad-hoc
//    List<Customer> findAll();
}
