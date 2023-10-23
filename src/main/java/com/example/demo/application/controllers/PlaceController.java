package com.example.demo.application.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.application.dtos.PlaceRequest;
import com.example.demo.application.dtos.PlaceResponse;
import com.example.demo.application.viewmodels.PlaceMapper;
import com.example.demo.domain.services.PlaceService;

import jakarta.validation.Valid;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("places")
public class PlaceController {
    
    @Autowired
    PlaceService placeService;

    @PostMapping("")
    public ResponseEntity<Mono<PlaceResponse>> create(@Valid @RequestBody PlaceRequest data){
        var place = placeService.create(data).map(PlaceMapper::fromPlaceToResponse);
        return ResponseEntity.status(HttpStatus.CREATED).body(place);
    }

    @GetMapping("test")
    public ResponseEntity<String> testMethod(){
        return ResponseEntity.status(HttpStatus.CREATED).body("Hello world");
    }
}
