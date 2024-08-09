package com.jsp.employeeapplication.controller;

import java.util.List;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.employeeapplication.Entity.Employee;
import com.jsp.employeeapplication.service.EmployeeService;
import com.jsp.employeeapplication.util.ResponseStructure;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeservice;

	@PostMapping("/saveemp")
	public ResponseEntity<ResponseStructure<Employee>> saveEmployee(@RequestBody Employee employee) {
		return employeeservice.saveEmployee(employee);

	}

	@PutMapping("/update")
	public ResponseEntity<ResponseStructure<Employee>> update(@RequestBody Employee employee) {
		return employeeservice.update(employee);

	}

	@DeleteMapping("/delete")
	public ResponseEntity<ResponseStructure<Employee>> delete(@RequestParam int id) {
		return employeeservice.deletebyId(id);
	}

	@GetMapping("/fetchempid")
	public ResponseEntity<ResponseStructure<Employee>> fetchbyId(@RequestParam int id) {
		return employeeservice.getbyId(id);

	}

	@GetMapping("/fetchAll")
	public ResponseEntity<ResponseStructure<List<Employee>>> getAllEmp() {
		return employeeservice.fetchAll();
	}

}

//public ResponseEntity<Employee> createEmployee(@RequestBody @Valid Employee employee) {
//    try {
//        Employee savedEmployee = employeeservice.saveEmployee(employee);
//        return new ResponseEntity<Employee>(savedEmployee, HttpStatus.CREATED);
//    } catch (ConstraintViolationException e) {
//        return new ResponseEntity<Employee>((Employee) e.getConstraintViolations(), HttpStatus.BAD_REQUEST);
//    }
//}

//@PostMapping("/saveem")
//public Employee saveem(Employee emm) {
//	return employeeservice.saveEmployee(emm);
//	
//}