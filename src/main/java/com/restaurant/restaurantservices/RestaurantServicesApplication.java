package com.restaurant.restaurantservices;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RestaurantServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestaurantServicesApplication.class, args);
		System.out.println("Restors app restaurant microservices is up and running on server 8080");
	}

	@Bean
	public ModelMapper modelMapper() {
		ModelMapper MAPPER = new ModelMapper();
		MAPPER.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

		return MAPPER;
	}

}
