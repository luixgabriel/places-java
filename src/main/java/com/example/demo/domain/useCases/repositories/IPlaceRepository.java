package com.example.demo.domain.useCases.repositories;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.example.demo.domain.models.Place;

public interface IPlaceRepository extends ReactiveCrudRepository<Place, Long> {
    
}
