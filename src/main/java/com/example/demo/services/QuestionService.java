package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Questions;
import com.example.demo.repositories.QuestionsRepository;
@Service
public class QuestionService {
	@Autowired
	private QuestionsRepository questionRepository;
	
	public List<Questions> getAllQuestion() {
		List<Questions> questions = new ArrayList<Questions>();
		questionRepository.findAll().forEach(question1 -> questions.add(question1));
		return questions;
	}
}
