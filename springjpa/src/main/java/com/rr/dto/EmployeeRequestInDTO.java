package com.rr.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class EmployeeRequestInDTO {

	private long id;
	
	@NotBlank
	@Size(min = 3,max = 20,message = "name should be 3 to 20 characters long")
	private String name;

	@NotBlank(message = "please enter address")
	private String address;
	
	
	@NotBlank(message = "please specify the role")
	private String role;

	
//	@Pattern(regexp="([6789]{1}[0-9]{9})", message = "invalid mobile number")
	private String contactNo;

	@Email(message = "please enter a valid email")
	@Pattern(regexp = "^[a-zA-Z0-9+_.-]+[@][a-zA-Z]{3,}[.][a-zA-Z]{2,3}$")
//	@Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-][.]+$")
	private String email;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
