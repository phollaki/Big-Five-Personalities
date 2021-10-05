package com.example.demo.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name="student_dim")
public class Student_Dim {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Sequence")
	@SequenceGenerator(name = "id_Sequence", sequenceName = "SEQ1", allocationSize = 1)
	private Long id;
	
	@Column(name="stu_id", unique = true)
	private String username;
	
	@Column(name="dep_code",nullable = false)
	private String dep_code;
	
	@Column(name="fac_code",nullable = false)
	private String fac_code;
	
	@Column(name="loc_code",nullable = false)
	private Long loc_code;
	
	@NotBlank
	@Size(max = 120)
	@Column(name="password",nullable = false)
	private String password;
	
	@Column(name="stu_fname",nullable = false)
	private String stu_fname;
	
	@Column(nullable = false)
	private String stu_lname;
	
	@Column(name="gender")
	private int gender;
	
	@Column(name="age")
	private int age;
	
	@Column(name="gp_avg")
	private double gp_avg;
	
	@Column(name="personality")
	private String personality;
	
	

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(	name = "user_roles", 
				joinColumns = @JoinColumn(name = "user_id"), 
				inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();

	
	public Student_Dim() {
		super();
	}
	
	public Student_Dim(String username, String stu_fname, String stu_lname, String dep_code, String fac_code,
			Long loc_code, @NotBlank @Size(max = 120) String password, int gender) {
		super();
		this.username = username;
		this.stu_fname = stu_fname;
		this.stu_lname = stu_lname;
		this.dep_code = dep_code;
		this.fac_code = fac_code;
		this.loc_code = loc_code;
		this.password = password;
		this.gender = gender;
	}


	public Student_Dim(Long id, String stu_id, String stu_fname, String stu_lname, String dep_code, String fac_code,
			Long loc_code, @NotBlank @Size(max = 120) String password,
			  String personality, int gender,
			Set<Role> roles) {
		super();
		this.id = id;
		this.username = stu_id;
		this.stu_fname = stu_fname;
		this.stu_lname = stu_lname;
		this.dep_code = dep_code;
		this.fac_code = fac_code;
		this.loc_code = loc_code;
		this.password = password;
		this.personality = personality;
		this.gender = gender;
		this.roles = roles;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getGp_avg() {
		return gp_avg;
	}

	public void setGp_avg(double gp_avg) {
		this.gp_avg = gp_avg;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStu_id() {
		return username;
	}

	public void setStu_id(String stu_id) {
		this.username = stu_id;
	}

	public String getStu_fname() {
		return stu_fname;
	}

	public void setStu_fname(String stu_fname) {
		this.stu_fname = stu_fname;
	}

	public String getStu_lname() {
		return stu_lname;
	}

	public void setStu_lname(String stu_lname) {
		this.stu_lname = stu_lname;
	}

	public String getDep_code() {
		return dep_code;
	}

	public void setDep_code(String dep_code) {
		this.dep_code = dep_code;
	}

	public String getFac_code() {
		return fac_code;
	}

	public void setFac_code(String fac_code) {
		this.fac_code = fac_code;
	}

	public Long getLoc_code() {
		return loc_code;
	}

	public void setLoc_code(Long loc_code) {
		this.loc_code = loc_code;
	}


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}



	public String getPersonality() {
		return personality;
	}

	public void setPersonality(String personality) {
		this.personality = personality;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
}