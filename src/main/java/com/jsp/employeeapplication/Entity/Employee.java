package com.jsp.employeeapplication.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;


import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

@Data
@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotNull(message = "firstName can't be null")
	private String firstName;
	@NotNull(message = "lastName can't be null")
	private String lastName;
	@Column(unique = true)
	private String Email;
	private String password;
	private String bloodgroup;
	private String availabilty;

	// relation employee and manager

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn
	@JsonBackReference
	private Manager manager;

}
