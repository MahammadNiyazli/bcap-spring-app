package com.company.bcapspringapp.dao.repository;

import com.company.bcapspringapp.dao.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {
     List<Card> findByCustomer_IdAndIsActive(Long customerId, Boolean isActive);

     @Query(value = "select * from card where customer_id = :customerId and is_active = :isActive", nativeQuery = true)
     List<Card> findByCustomer_IdAndIsActiveWithQuery(@Param("customerId") Long customerId,
                                                      @Param("isActive") Boolean isActive);

     @Query(value = "select c from Card c where c.customer.id = :customerId and c.isActive = :isActive")
     List<Card> findByCustomer_IdAndIsActiveWithJQPL(@Param("customerId") Long customerId,
                                                      @Param("isActive") Boolean isActive);
}
