package com.example.demo.application.viewmodels;

import com.example.demo.application.dtos.PlaceResponse;
import com.example.demo.domain.models.Place;

public class PlaceMapper {
    public static PlaceResponse fromPlaceToResponse(Place place){
        return new PlaceResponse(place.name(), place.slug(), place.state(), place.createdAt(), place.updatedAt());
    }
}
