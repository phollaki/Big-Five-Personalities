package com.example.demo.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Student_Dim;


@Repository
public interface Student_DimRepository extends JpaRepository<Student_Dim, Long> {
	Optional<Student_Dim> findByUsername(String stu_id);
	Boolean existsByUsername(String stu_id);
}
