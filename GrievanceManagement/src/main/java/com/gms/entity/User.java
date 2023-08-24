package com.gms.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

/**
 * this is user entity for storing user details 
 */
@Entity
@Table(name = "user_details")
public class User {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
    @NotEmpty
    @Size(min=2,max=30,message = "name must be in 2-30  characters long ")
	private String name;
    @NotEmpty
    @Pattern(regexp = "^[a-z]{2,}[.][a-z]{2,}+@nucleusteq.com$",message = "please enter valid username ")
	private String email;
    @NotEmpty
	private String role;
    @Size(min=8,max=20)
    @NotEmpty(message = "password must be combination of uppercase ,lowercase and special symbol")
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[1-9])(?=.*[@$!%*?&])[A-Za-z1-9@$!%*?&]{8,20}$")
    private String password;
    
    @JsonIgnore
	@OneToMany(mappedBy = "user")
	private List<Ticket> ticket;
    
	@ManyToOne
	@JsonIgnore
	private Department department;
	@OneToMany(mappedBy = "user")
	private List<Comment> comments;
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
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public List<Ticket> getTicket() {
        return ticket;
    }
    public void setTicket(List<Ticket> ticket) {
        this.ticket = ticket;
    }
    public Department getDepartment() {
        return department;
    }
    public void setDepartment(Department department) {
        this.department = department;
    }
    public List<Comment> getComments() {
        return comments;
    }
    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
	
	
}
