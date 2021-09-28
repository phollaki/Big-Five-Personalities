package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class StudentManagementSystem1Application {

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementSystem1Application.class, args);
		 
		
		  for (int i = 1001; i < 5001; i++) {
		  System.out.println("EXECUTE what_is_my_personality ("+i+");"); }
		 
	}

}
