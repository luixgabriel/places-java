package com.example.demo.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.application.dtos.PlaceRequest;
import com.example.demo.domain.models.Place;
import com.example.demo.domain.useCases.repositories.IPlaceRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PlaceService {
    
    @Autowired
    IPlaceRepository placeRepository;

    public Mono<Place> create(PlaceRequest data){
        var place = new Place(null, data.name(), data.slug(), data.state(), data.createdAt(), data.updatedAt());
        return placeRepository.save(place);
    }

    public Flux<Place> findAll(){
        return placeRepository.findAll();
    }
}
