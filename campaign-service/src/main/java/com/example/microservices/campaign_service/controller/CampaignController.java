package com.example.microservices.campaign_service.controller;

import com.example.microservices.campaign_service.dto.ApiResponse;
import com.example.microservices.campaign_service.dto.CampaignRequest;
import com.example.microservices.campaign_service.dto.PublisherDTO;
import com.example.microservices.campaign_service.model.Campaign;
import com.example.microservices.campaign_service.service.CampaignService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/campaign")
@RequiredArgsConstructor
public class CampaignController {

    private final CampaignService campaignService;

    @PostMapping
    public ResponseEntity<ApiResponse<Campaign>> createCampaign(@RequestBody CampaignRequest campaignRequest) {
        try{
            Campaign campaign = campaignService.createCampaign(campaignRequest);
            ApiResponse<Campaign> response = new ApiResponse<Campaign>(true, "Campaign created successfully", campaign);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (Exception e) {
            ApiResponse<Campaign> response = new ApiResponse<>(false, "Campaign not found", null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Campaign>>> getAllCampaigns() {
        try {
            List<Campaign> campaigns = campaignService.getCampaigns();
            ApiResponse<List<Campaign>> response = new ApiResponse<>(true, "Campaigns Fetched", campaigns);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            ApiResponse<List<Campaign>> response = new ApiResponse<>(false, "Error fetching campaigns", null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Campaign>> getCampaignById(@PathVariable Long id) {
        try {
            Campaign campaign = campaignService.getCampaignById(id);
            ApiResponse<Campaign> response = new ApiResponse<>(true, "Campaign Fetched By Id", campaign);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            ApiResponse<Campaign> response = new ApiResponse<>(false, "Campaign not found", null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @GetMapping("/publishers")
    public ResponseEntity<ApiResponse<List<PublisherDTO>>> getAllPublishers() {
        try {
            List<PublisherDTO> publishers = campaignService.getPublishers();
            ApiResponse<List<PublisherDTO>> response = new ApiResponse<>(true, "Campaigns Fetched", publishers);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            ApiResponse<List<PublisherDTO>> response = new ApiResponse<>(false, "Error fetching campaigns", null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
}
