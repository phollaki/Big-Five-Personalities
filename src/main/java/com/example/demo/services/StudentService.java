package com.example.demo.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Results;
import com.example.demo.entities.Student_Dim;
import com.example.demo.exceptions.StudentNotFoundException;
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
	
	/*public void autogenerator(int i) {
		String[] first_names = { "Adam", "Alex", "Aaron", "Ben", "Carl", "Dan", "David", "Edward", "Fred", "Frank", "George", "Hal", "Hank", "Ike", "John", "Jack", "Joe", "Larry", "Monte", "Matthew", "Mark", "Nathan", "Otto", "Paul", "Peter", "Roger", "Roger", "Steve", "Thomas", "Tim", "Ty", "Victor", "Walter", "Ákos", "Péter", "József","Dávid","Gellért","Réka","Luca","Máté","Lajos","Ernő","Gabriella","Adolf","Ádám","Csepel","Balázs","Krisztián","Alexandra","Lilla","Liza","Csilla","Gábor","Titanilla","Ferenc","Tom","Tamás","Thomas","Patrik","Patric","Gizella"};
		String[] last_names = { "Anderson", "Ashwoon", "Aikin", "Bateman", "Bongard", "Bowers", "Boyd", "Cannon", "Cast", "Deitz", "Dewalt", "Ebner", "Frick", "Hancock", "Haworth", "Hesch", "Hoffman", "Kassing", "Knutson", "Lawless", "Lawicki", "Mccord", "McCormack", "Miller", "Myers", "Nugent", "Ortiz", "Orwig", "Ory", "Paiser", "Pak", "Pettigrew", "Quinn", "Quizoz", "Ramachandran", "Resnick", "Sagar", "Schickowski", "Schiebel", "Sellon", "Severson", "Shaffer", "Solberg", "Soloman", "Sonderling", "Soukup", "Soulis", "Stahl", "Sweeney", "Tandy", "Trebil", "Trusela", "Trussel", "Turco", "Uddin", "Uflan", "Ulrich", "Upson", "Vader", "Vail", "Valente", "Van Zandt", "Vanderpoel", "Ventotla", "Vogal", "Wagle", "Wagner", "Wakefield", "Weinstein", "Weiss", "Woo", "Yang", "Yates", "Yocum", "Zeaser", "Zeller", "Ziegler", "Bauer", "Baxster", "Casal", "Cataldi", "Caswell", "Celedon", "Chambers", "Chapman", "Christensen", "Darnell", "Davidson", "Davis", "DeLorenzo", "Dinkins", "Doran", "Dugelman", "Dugan", "Duffman", "Eastman", "Ferro", "Ferry", "Fletcher", "Fietzer", "Hylan", "Hydinger", "Illingsworth", "Ingram", "Irwin", "Jagtap", "Jenson", "Johnson", "Johnsen", "Jones", "Jurgenson", "Kalleg", "Kaskel", "Keller", "Leisinger", "LePage", "Lewis", "Linde", "Lulloff", "Maki", "Martin", "McGinnis", "Mills", "Moody", "Moore", "Napier", "Nelson", "Norquist", "Nuttle", "Olson", "Ostrander", "Reamer", "Reardon", "Reyes", "Rice", "Ripka", "Roberts", "Rogers", "Root", "Sandstrom", "Sawyer", "Schlicht", "Schmitt", "Schwager", "Schutz", "Schuster", "Tapia", "Thompson", "Tiernan", "Tisler"};
		Student_Dim student = new Student_Dim();
		i += 120;
		for (int j = 0; j < i; j++) {
			int random = (int)(Math.random()*first_names.length-1);
			int random2 = (int)(Math.random()*last_names.length-1);
			int random3 = (int)(Math.random()*12)+1;
			String depcode = "d" + Integer.toString(random3);
			String faccode = "Fac_" + Integer.toString(random3);
			String loccode = "loc1";
			String gender = "male";
			if(j%2==0)gender="female";
			if(random3 > 5 ? loccode == "loc1" : loccode == "loc2");
			student.setStu_id("stud"+ Integer.toString(j));
			student.setStu_fname(first_names[random]);
			student.setStu_lname(last_names[random2]);
			student.setDep_code(depcode);
			student.setFac_code(faccode);
			student.setLoc_code(loccode);
			student.setPassword("123456");
			student.setGender(gender);
			System.out.println(student.getFac_code() + " " + student.getDep_code());
			studentRepository.save(student);
		}
			
	}*/

	public List<Student_Dim> getAllStudent() {
		List<Student_Dim> students = new ArrayList<Student_Dim>();
		studentRepository.findAll().forEach(student->students.add(student));
		return students;
	}
}

