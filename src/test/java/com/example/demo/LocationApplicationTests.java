package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.example.demo.application.dtos.PlaceRequest;

@SpringBootTest
class LocationApplicationTests {

  @Autowired
  WebTestClient webTestClient;

  @Test
  public void testCreatePlaceSuccess(){
	var name = "valid name";
	var state = "valid state";
	var city = "valid city";

	webTestClient.post()
	.uri("/places")
	.bodyValue(new PlaceRequest(name,city, state))
	.exchange()
	.expectBody()
	.jsonPath("name").isEqualTo(name);
  }

}
