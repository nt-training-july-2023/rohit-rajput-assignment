package com.rr.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "employee_details",uniqueConstraints = @UniqueConstraint(columnNames = "email"))
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long empId;
	
	@NotBlank
	@Size(min=3,max=20)
	private String name;
	
	@NotNull
	private String address;
	
	@NotBlank
	private String role;
	
	@Size(min=10,max=10)
	@Column( nullable = false)
	private String contactNo;
	
	@Email
	@NotNull
	private String email;
}
