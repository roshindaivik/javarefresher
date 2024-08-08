package com.example.microservices.publisher_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.microservices.publisher_service.model.Publisher;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {
}
