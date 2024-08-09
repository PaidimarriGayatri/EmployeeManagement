package com.jsp.employeeapplication.Entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;


@Data
@Entity
public class Manager {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotNull(message = "name can't be null")
	private String Name;
	@Column(unique = true)
	private String email;
	private String password;
	private long phone;
	private String bloodgroup;
	private String availabilty;
	@JsonIgnore
	@OneToMany(mappedBy = "manager")
	private List<Employee> employee;

}
