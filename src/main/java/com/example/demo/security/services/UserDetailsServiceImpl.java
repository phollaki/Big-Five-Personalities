package com.example.demo.security.services;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entities.Student_Dim;
import com.example.demo.repositories.Student_DimRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	Student_DimRepository student_dimRepository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String stu_id) throws UsernameNotFoundException {
		Student_Dim user = student_dimRepository.findByUsername(stu_id)
				.orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + stu_id));

		return UserDetailsImpl.build(user);
	}

}