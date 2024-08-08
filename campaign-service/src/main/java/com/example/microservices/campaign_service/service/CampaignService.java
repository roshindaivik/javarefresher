package com.example.microservices.campaign_service.service;

import com.example.microservices.campaign_service.client.PublisherClient;
import com.example.microservices.campaign_service.dto.CampaignRequest;
import com.example.microservices.campaign_service.dto.PublisherDTO;
import com.example.microservices.campaign_service.model.Campaign;
import com.example.microservices.campaign_service.repository.CampaignRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CampaignService {

    private final CampaignRepository campaignRepository;
    private final PublisherClient publisherClient;

    public Campaign createCampaign(CampaignRequest campaignRequest){
        Campaign campaign = mapToCampaign(campaignRequest);
        return campaignRepository.save(campaign);
    }

    public List<Campaign> getCampaigns(){
        return campaignRepository.findAll();
    }

    public List<PublisherDTO> getPublishers() {
        return publisherClient.getPublishers().getData();
    }

    public Campaign getCampaignById(Long id){
        return campaignRepository.findById(id).orElse(null);
    }

    private static Campaign mapToCampaign(CampaignRequest campaignRequest) {
        Campaign campaign = new Campaign();
        campaign.setName(campaignRequest.name());
        campaign.setDescription(campaignRequest.description());
        campaign.setBidding(campaignRequest.bidding());
        campaign.setTotalBudget(campaignRequest.totalBudget());
        campaign.setBalanceBudget(campaignRequest.balanceBudget());
        campaign.setEmail(campaignRequest.email());
        return campaign;
    }

}
