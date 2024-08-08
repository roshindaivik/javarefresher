package com.example.microservices.campaign_service.dto;


import java.math.BigDecimal;

public record CampaignRequest(Long id, String name,String email,String description, BigDecimal bidding,  BigDecimal totalBudget , BigDecimal balanceBudget) {
}

