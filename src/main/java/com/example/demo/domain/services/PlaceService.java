package com.example.demo.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.r2dbc.config.EnableR2dbcAuditing;
import org.springframework.stereotype.Service;

import com.example.demo.application.dtos.PlaceRequest;
import com.example.demo.domain.models.Place;
import com.example.demo.domain.useCases.repositories.IPlaceRepository;
import com.github.slugify.Slugify;

import jakarta.annotation.PostConstruct;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@EnableR2dbcAuditing
@Service
public class PlaceService {
    
    @Autowired
    IPlaceRepository placeRepository;
    private Slugify slg;

    public PlaceService(){
        this.slg = slg.builder().build();
    }

    public Mono<Place> create(PlaceRequest data){
        var place = new Place(null, data.name(), slg.slugify(data.name()), data.city(), data.state(), null, null);
        return placeRepository.save(place);
    }

    public Flux<Place> findAll(){
        return placeRepository.findAll();
    }
}
