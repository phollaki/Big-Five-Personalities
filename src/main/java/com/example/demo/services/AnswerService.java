package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Answers;
import com.example.demo.repositories.AnswersRepository;

@Service
public class AnswerService {

	@Autowired
	private AnswersRepository answersRepository;
	
	public List<Answers> getAllAnswers(){
		List<Answers> answers = new ArrayList<Answers>();
		answersRepository.findAll().forEach(answer -> answers.add(answer));
		return answers;
	}
}
