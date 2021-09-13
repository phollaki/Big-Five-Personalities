package com.example.demo.controllers;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entities.ERole;
import com.example.demo.entities.Role;
import com.example.demo.entities.Student_Dim;
import com.example.demo.payload.request.LoginRequest;
import com.example.demo.payload.request.SignupRequest;
import com.example.demo.payload.response.JwtResponse;
import com.example.demo.payload.response.MessageResponse;
import com.example.demo.repositories.RoleRepository;
import com.example.demo.repositories.Student_DimRepository;
import com.example.demo.security.jwt.JwtUtils;
import com.example.demo.security.services.UserDetailsImpl;
import com.example.demo.services.AnswerService;
import com.example.demo.services.QuestionService;
import com.example.demo.services.ResultService;
import com.example.demo.services.StudentService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AppController {
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	Student_DimRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtUtils jwtUtils;
	
	@Autowired
	private QuestionService questionService;

	@Autowired
	private AnswerService answerService;
	
	@Autowired
	private ResultService resultService;
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/test")
	public HashMap<String, List<?>> viewTestPage() {
		HashMap<String,List<?>> answersAndQuestions = new HashMap<String,List<?>>();
		answersAndQuestions.put("answers", answerService.getAllAnswers());
		answersAndQuestions.put("questions", questionService.getAllQuestion());
		return answersAndQuestions;
	}
	@PostMapping("/result")
	public String getTestResult(@RequestBody Map<String,String> list) {
		resultService.saveOrUpdate(list);
		String stuid = list.get("0");
	    resultService.insertPersonality(stuid);
	    String personality = studentService.getPersonality(Long.parseLong(stuid));
		return personality;
	}
	@PostMapping("/personality")
	public String getPersonality(@RequestBody String id) {
		String[] splitId = id.split("=");
		return studentService.getPersonality(Long.parseLong(splitId[0]));
	}
	@RequestMapping("/compare")  
	private List<Double[]> getCompareData(@RequestBody Map<String,String> list){
		String id = list.get("id");
		String stuid = list.get("stuid");
		System.out.println(id + " " + stuid);
		Double [] student = resultService.getStudentResult(stuid);
		Double [] student2 = resultService.getStudentResult(id);
		System.out.println(Arrays.toString(student));
		System.out.println(Arrays.toString(student2));
		List<Double[]> data = new ArrayList<Double[]>();
		data.add(student);
		data.add(student2);
		return data;
	} 
	/*
	 * @PostMapping("/result") private ModelAndView saveOrUpdate(HttpServletRequest
	 * request) { List<String> list = new ArrayList<String>(); List<String> list2 =
	 * new ArrayList<String>(); Map<String, String[]> requestParameterMap =
	 * request.getParameterMap(); for(String key : requestParameterMap.keySet()){
	 * list.add(requestParameterMap.get(key)[0]); list2.add(key); }
	 * resultService.saveOrUpdate(list, list2); resultService.insertPersonality();
	 * Student_Dim result = studentService.findStudentById();
	 * System.out.println(result.getPersonality()); return new
	 * ModelAndView("resultpage", "result", result); }
	 */
	

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);
		
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();		
		List<String> roles = userDetails.getAuthorities().stream()
				.map(item -> item.getAuthority())
				.collect(Collectors.toList());

		return ResponseEntity.ok(new JwtResponse(jwt, 
												 userDetails.getId(), 
												 userDetails.getUsername(), 
												 userDetails.getEmail(),
												 userDetails.getPersonality(),
												 roles));
	}

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
		if (userRepository.existsByUsername(signUpRequest.getStu_id())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Username is already taken!"));
		}


		// Create new user's account
		Student_Dim user = new Student_Dim(signUpRequest.getStu_id(),
				 			 signUpRequest.getStu_fname(),
				 			 signUpRequest.getStu_lname(),
							 signUpRequest.getDep_code(),
							 signUpRequest.getFac_code(),
							 signUpRequest.getLoc_code(),
							 encoder.encode(signUpRequest.getPassword()),	
							 signUpRequest.getGender()
							 );

		Set<String> strRoles = signUpRequest.getRole();
		Set<Role> roles = new HashSet<>();

		if (strRoles == null) {
			Role userRole = roleRepository.findByName(ERole.ROLE_USER)
					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
			roles.add(userRole);
		} else {
			strRoles.forEach(role -> {
				switch (role) {
				case "admin":
					Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(adminRole);

					break;
				
				default:
					Role userRole = roleRepository.findByName(ERole.ROLE_USER)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(userRole);
				}
			});
		}

		user.setRoles(roles);
		userRepository.save(user);

		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
	}
}