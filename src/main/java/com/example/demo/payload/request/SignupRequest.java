package com.example.demo.payload.request;
import java.util.Set;

import javax.validation.constraints.*;
 
public class SignupRequest {
	
    @NotBlank
    @Size(min = 4, max = 20)
    private String stu_id;
 
    @NotBlank
    @Size(max = 50)
    @Email
    private String email;
    
    private Set<String> role;
    
    @NotBlank
    @Size(min = 6, max = 40)
    private String password;
  
    @NotBlank
    @Size(max = 20)
    @Email
    private String stu_fname;
    
    @NotBlank
    @Size(max = 20)
    @Email
    private String stu_lname;
    
    @NotBlank
    @Size(max = 20)
    @Email
    private String gender;
    
    @NotBlank
    @Size(max = 9)
    @Email
    private String loc_code;
    
    @NotBlank
    @Size(max = 9)
    @Email
    private String fac_code;
    
    @NotBlank
    @Size(max = 9)
    @Email
    private String dep_code;
    
    @Size(max = 50)
    @Email
    private String address;
    
    @Size(max = 20)
    @Email
    private String marriage_status;

    
    
	public String getStu_id() {
		return stu_id;
	}

	public void setStu_id(String stu_id) {
		this.stu_id = stu_id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<String> getRole() {
		return role;
	}

	public void setRole(Set<String> role) {
		this.role = role;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getLoc_code() {
		return loc_code;
	}

	public void setLoc_code(String loc_code) {
		this.loc_code = loc_code;
	}

	public String getFac_code() {
		return fac_code;
	}

	public void setFac_code(String fac_code) {
		this.fac_code = fac_code;
	}

	public String getDep_code() {
		return dep_code;
	}

	public void setDep_code(String dep_code) {
		this.dep_code = dep_code;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMarriage_status() {
		return marriage_status;
	}

	public void setMarriage_status(String marriage_status) {
		this.marriage_status = marriage_status;
	}
    
}
