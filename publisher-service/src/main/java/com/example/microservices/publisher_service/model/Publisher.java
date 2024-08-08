package com.example.microservices.publisher_service.model;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.*;


@Entity
@Table(name = "publisher")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Publisher {

    private String name;
    private String url;
    private int numberOfAdSpaces;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


}