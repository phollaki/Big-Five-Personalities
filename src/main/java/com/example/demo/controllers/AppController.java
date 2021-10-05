package com.example.demo.controllers;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.fluent.Form;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
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

import com.example.demo.PersonalityHelper;
import com.example.demo.entities.ERole;
import com.example.demo.entities.Location_Dim;
import com.example.demo.entities.Results;
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
import com.example.demo.services.LocationService;
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
	
	@Autowired
	private LocationService locationService;
	
	@GetMapping("/test")
	public HashMap<String, List<?>> viewTestPage() {
		HashMap<String,List<?>> answersAndQuestions = new HashMap<String,List<?>>();
		answersAndQuestions.put("answers", answerService.getAllAnswers());
		answersAndQuestions.put("questions", questionService.getAllQuestion());
		return answersAndQuestions;
	}
	
	@PostMapping("/result")
	public String getTestResult(@RequestBody Map<String,String> list) throws ClientProtocolException, IOException {
		int[] answers = resultService.saveOrUpdate(list);
		String stuid = list.get("0");
		resultService.insertPersonality(stuid);
	    String personality = studentService.getPersonality(Long.parseLong(stuid));
	    System.out.println("My calculation"+personality);
		Optional<Student_Dim> student = studentService.getStudentInformation(Long.parseLong(stuid));
		Optional<Location_Dim> location = locationService.getLocation(student.get().getLoc_code());
		try {
		HttpResponse response = Request.Post("http://127.0.0.1:5000/personality").bodyForm(
			      Form.form().add("answ0",Integer.toString(answers[0]))
			      .add("answ1",Integer.toString(answers[1]))
			      .add("answ2",Integer.toString(answers[2]))
			      .add("answ3",Integer.toString(answers[3]))
			      .add("answ4",Integer.toString(answers[4]))
			      .add("answ5",Integer.toString(answers[5]))
			      .add("answ6",Integer.toString(answers[6]))
			      .add("answ7",Integer.toString(answers[7]))
			      .add("answ8",Integer.toString(answers[8]))
			      .add("answ9",Integer.toString(answers[9]))
			      .add("answ10",Integer.toString(answers[10]))
			      .add("answ11",Integer.toString(answers[11]))
			      .add("answ12",Integer.toString(answers[12]))
			      .add("answ13",Integer.toString(answers[13]))
			      .add("answ14",Integer.toString(answers[14]))
			      .add("answ15",Integer.toString(answers[15]))
			      .add("answ16",Integer.toString(answers[16]))
			      .add("answ17",Integer.toString(answers[17]))
			      .add("answ18",Integer.toString(answers[18]))
			      .add("answ19",Integer.toString(answers[19]))
			      .add("age",Integer.toString(student.get().getAge()))
			      .add("gender",Integer.toString(student.get().getGender()))
			      .add("density",Integer.toString(location.get().getDensity()))
			      .add("avg_temp",Integer.toString((int) location.get().getAverage_temp()))
			      .add("invi_score",Integer.toString(location.get().getInvidualism_score()))
			      .add("gp_avg",Integer.toString((int)student.get().getGp_avg()))
			      .build())
			      .execute().returnResponse();
		String responseString = new BasicResponseHandler().handleResponse(response);
		studentService.insertPersonality(Long.parseLong(stuid),responseString);
		}catch(Exception ex) {
			System.out.println(ex);
		}
	    String personality2 = studentService.getPersonality(Long.parseLong(stuid));
	    System.out.println("Python ML calculation"+personality2);

		return personality2;
	}
	
	@PostMapping("/guest")
	public String getGuestTestResult(@RequestBody Map<String,String> list) throws ClientProtocolException, IOException  {
		String gender = "1";
		if(list.get("gender").equals("Female")) {
			gender = "2";
		}
		HttpResponse response = Request.Post("http://127.0.0.1:5000/personality").bodyForm(
			      Form.form()
			      .add("answ0",list.get("opn1"))
			      .add("answ1",list.get("opn2"))
			      .add("answ2",list.get("opn3"))
			      .add("answ3",list.get("opn4"))
			      .add("answ4",list.get("agg1"))
			      .add("answ5",list.get("agg2"))
			      .add("answ6",list.get("agg3"))
			      .add("answ7",list.get("agg4"))
			      .add("answ8",list.get("neu1"))
			      .add("answ9",list.get("neu2"))
			      .add("answ10",list.get("neu3"))
			      .add("answ11",list.get("neu4"))
			      .add("answ12",list.get("ext1"))
			      .add("answ13",list.get("ext2"))
			      .add("answ14",list.get("ext3"))
			      .add("answ15",list.get("ext4"))
			      .add("answ16",list.get("csn1"))
			      .add("answ17",list.get("csn2"))
			      .add("answ18",list.get("csn3"))
			      .add("answ19",list.get("csn4"))
			      .add("age",list.get("age"))
			      .add("gender",gender)
			      .add("density","3")
			      .add("avg_temp","9")
			      .add("invi_score","80")
			      .add("gp_avg","0")
			      .build())
			      .execute().returnResponse();
		String responseString = new BasicResponseHandler().handleResponse(response);
		return responseString;
	}
	
	@PostMapping("/personality")
	public PersonalityHelper getPersonality(@RequestBody String id) {
		String[] splitId = id.split("=");
		Double [] student = resultService.getStudentResult(splitId[0]);
		String personality = studentService.getPersonality(Long.parseLong(splitId[0]));
		PersonalityHelper ph = new PersonalityHelper(personality,student[0],student[1],student[2],student[3],student[4],"");
		return ph;
	}
	@PostMapping("/calculations")
	public HashMap<String, Object> getCalculationData(@RequestBody String id) {
		HashMap<String,Object> data = new HashMap<String,Object>();
		String[] splitId = id.split("=");
		Optional<Results> studentResult = resultService.getStudentResultData(Long.parseLong(splitId[0]));
		Optional<Student_Dim> student = studentService.getStudentInformation(Long.parseLong(splitId[0]));
		Optional<Location_Dim> location = locationService.getLocation(student.get().getLoc_code());
		data.put("location",location);
		data.put("questions", questionService.getAllQuestion());
		data.put("results", studentResult);
		data.put("student", student);
		return data;
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
												 userDetails.getPersonality(),
												 roles));
	}
	/*
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
	}*/
}