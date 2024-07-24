package com.company.bcapspringapp.dao.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
@Getter
@Setter
@Entity
@Table(name = "transactions")
public class Transactions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Basic(optional = false)
    private String description;
    @Column(name = "sender_card_number")
    private String senderCardNumber;
    @Column(name = "receiver_card_number")
    private String receiverCardNumber;
    private String status;
    private Double amount;
    @Column(name = "ccy_code")
    private String ccyCode;
    @Column(name = "is_active")
    private Boolean isActive;
    @Column(name = "created_at")
    private Timestamp createdAt;
    @Column(name = "updated_at")
    private Timestamp updatedAt;
}
