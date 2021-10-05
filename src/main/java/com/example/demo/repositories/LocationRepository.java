package com.example.demo.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entities.Location_Dim;

public interface LocationRepository extends CrudRepository<Location_Dim, Long> {

}
