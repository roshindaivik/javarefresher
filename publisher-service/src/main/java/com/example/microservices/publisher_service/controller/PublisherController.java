package com.example.microservices.publisher_service.controller;

import com.example.microservices.publisher_service.dto.ApiResponse;
import com.example.microservices.publisher_service.dto.PublisherBody;
import com.example.microservices.publisher_service.model.Publisher;
import com.example.microservices.publisher_service.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/publishers")
public class PublisherController {

    private final PublisherService publisherService;

    @Autowired
    public PublisherController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Publisher>> createPublisher(@RequestBody PublisherBody publisherBody) {
        Publisher createdPublisher = publisherService.createPublisher(publisherBody);
        ApiResponse<Publisher> response = new ApiResponse<>(true, "Publisher created successfully", createdPublisher);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Publisher>>> getAllPublishers() {
        List<Publisher> publishers = publisherService.getAllPublishers();
        ApiResponse<List<Publisher>> response = new ApiResponse<>(true, "Publishers retrieved successfully", publishers);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public  ResponseEntity<ApiResponse<Publisher>> updatePublisher(@PathVariable Long id,
                                                                   @RequestBody PublisherBody publisherBody) {
        Publisher updatedPublisher = publisherService.updatePublisher(id,publisherBody);
        ApiResponse<Publisher> response = new ApiResponse<>(true, "Publisher updated successfully", updatedPublisher);
        return ResponseEntity.ok(response);
    }
}