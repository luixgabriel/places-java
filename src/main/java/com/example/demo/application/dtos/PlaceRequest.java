package com.example.demo.application.dtos;

import java.time.LocalDateTime;

public record PlaceRequest(String name, String slug, String city, String state, LocalDateTime createdAt, LocalDateTime updatedAt){

}
    

