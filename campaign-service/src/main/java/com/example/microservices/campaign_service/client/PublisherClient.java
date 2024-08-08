package com.example.microservices.campaign_service.client;

import com.example.microservices.campaign_service.dto.ApiResponse;
import com.example.microservices.campaign_service.dto.PublisherDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(value = "publisher-service",url = "http://localhost:8000")
public interface PublisherClient {
    @GetMapping("/api/publishers")
    ApiResponse<List<PublisherDTO>> getPublishers();

    @GetMapping("/api/publishers/{id}")
    ApiResponse<PublisherDTO> getPublisherById(@PathVariable("id") Long id);

}
