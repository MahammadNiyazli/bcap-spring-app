package com.company.bcapspringapp.dao.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
@Getter
@Setter
@Entity
@Table(name = "card")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(name = "card_number")
    private String cardNumber;
    private String pin;
    @Column(name = "ccy_code")
    private String ccyCode;
    @Column(name = "holder_name")
    private String holderName;
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Customer customer;
    @Column(name = "is_active")
    private Boolean isActive;
    @Column(name = "expire_date")
    private Timestamp expireDate;
    @Column(name = "created_at")
    private Timestamp createdAt;
    @Column(name = "updated_at")
    private Timestamp updatedAt;

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                ", pin='" + pin + '\'' +
                ", ccyCode='" + ccyCode + '\'' +
                ", holderName='" + holderName + '\'' +
                ", isActive=" + isActive +
                ", expireDate=" + expireDate +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
