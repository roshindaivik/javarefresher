package com.example.microservices.campaign_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.microservices.campaign_service.model.Campaign;

public interface CampaignRepository extends JpaRepository<Campaign, Long> {
}
