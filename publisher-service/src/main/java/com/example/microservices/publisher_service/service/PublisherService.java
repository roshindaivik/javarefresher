package com.example.microservices.publisher_service.service;

import com.example.microservices.publisher_service.dto.PublisherBody;
import com.example.microservices.publisher_service.model.Publisher;
import com.example.microservices.publisher_service.repository.PublisherRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Data
@Slf4j
public class PublisherService {

    private final PublisherRepository publisherRepository;

    @Autowired
    public PublisherService(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    public Publisher createPublisher(PublisherBody publisherBody) {
        if (!validatePublisherBody(publisherBody)) {
            throw new IllegalArgumentException("Invalid publisher data. Please check all required fields.");
        }

        Publisher publisher = new Publisher();
        publisher.setName(publisherBody.name());
        publisher.setUrl(publisherBody.url());
        publisher.setNumberOfAdSpaces(publisherBody.numberOfAdSpaces());

        return publisherRepository.save(publisher);
    }

    public List<Publisher> getAllPublishers() {
        return publisherRepository.findAll();
    }

    public Publisher updatePublisher(Long id, PublisherBody publisherBody) {
        boolean validation = this.validatePublisherBody(publisherBody);
        if (id == null || !validation) {
            throw new IllegalArgumentException("ID and update data must not be null");
        }
        Optional<Publisher> optionalPublisher = publisherRepository.findById(id);
        if (optionalPublisher.isEmpty()) {
            throw new EntityNotFoundException("Publisher with id " + id + " not found");
        }
        Publisher publisher = optionalPublisher.get();
        publisher.setName(publisherBody.name());
        publisher.setUrl(publisherBody.url());
        publisher.setNumberOfAdSpaces(publisherBody.numberOfAdSpaces());
        return publisherRepository.save(publisher);
    }

    private boolean validatePublisherBody(PublisherBody publisherBody) {
        if (publisherBody == null) {
            return false;
        }
        return publisherBody.name() != null && !publisherBody.name().isBlank() &&
                publisherBody.url() != null && !publisherBody.url().isBlank() &&
                publisherBody.numberOfAdSpaces() > 0;
    }
}