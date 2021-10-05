package com.example.demo.services;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Location_Dim;
import com.example.demo.repositories.LocationRepository;

@Service
public class LocationService {
	@Autowired
	private LocationRepository locationRepository;

	public Optional<Location_Dim> getLocation(Long id){
		return locationRepository.findById(id);
	}
}
