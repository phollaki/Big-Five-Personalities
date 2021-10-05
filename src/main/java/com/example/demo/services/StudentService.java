package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Student_Dim;
import com.example.demo.repositories.Student_DimRepository;

@Service
public class StudentService {
	@Autowired
	Student_DimRepository studentRepository;
	
	public Optional<Student_Dim> findStudentById(Long id) {
		return studentRepository.findById(id);
	}
	public String getPersonality(Long id) {
		Optional<Student_Dim> student = studentRepository.findById(id);
		String personality = "";
		if(student.isPresent()) {
			personality = student.get().getPersonality();
		}
		return personality;
	}
	public Optional<Student_Dim> getStudentInformation(Long id){
		return studentRepository.findById(id);
	}
	public void insertPersonality(Long id,String personality) {
		Optional<Student_Dim> student = studentRepository.findById(id);
		Student_Dim savedStudent = student.get();
		savedStudent.setPersonality(personality);
		if(student.isPresent()) {
			studentRepository.save(savedStudent);
		}
	}
	public List<Student_Dim> getAllStudent() {
		List<Student_Dim> students = new ArrayList<Student_Dim>();
		studentRepository.findAll().forEach(student->students.add(student));
		return students;
	}
}

