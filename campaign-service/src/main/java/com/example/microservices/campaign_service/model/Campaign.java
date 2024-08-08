package com.example.microservices.campaign_service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "campaign")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Campaign {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private String email;

    @Column(precision = 10, scale = 2)
    private BigDecimal bidding;

    @Column(precision = 10, scale = 2)
    private BigDecimal totalBudget;

    @Column(precision = 10, scale = 2)
    private BigDecimal balanceBudget;
}

