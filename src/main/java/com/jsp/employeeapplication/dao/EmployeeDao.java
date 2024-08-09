package com.jsp.employeeapplication.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.employeeapplication.Entity.Employee;
import com.jsp.employeeapplication.exception.IdNotPresentException;
import com.jsp.employeeapplication.repo.Employeerepo;

@Repository
public class EmployeeDao {

	@Autowired
	private Employeerepo employeerepo;

	// save
	public Employee saveEmployee(Employee employee) {
		return employeerepo.save(employee);

	}

	// update
	public Employee update(Employee employeeupdate) {

		Employee db = this.getempbyId(employeeupdate.getId());
		if (db != null) {
			if (employeeupdate.getEmail() != null) {
				db.setEmail(employeeupdate.getEmail());
			}
			if (employeeupdate.getFirstName() != null) {
				db.setFirstName(employeeupdate.getFirstName());

			}
			if (employeeupdate.getLastName() != null) {
				db.setLastName(employeeupdate.getLastName());

			}
			if (employeeupdate.getPassword() != null) {
				db.setPassword(employeeupdate.getPassword());
			}
			if (employeeupdate.getAvailabilty() != null) {
				db.setAvailabilty(employeeupdate.getAvailabilty());
			}
			if (employeeupdate.getBloodgroup() != null) {
				db.setBloodgroup(employeeupdate.getBloodgroup());
			}
			return employeerepo.save(db);
		} else
			return null;

	}

	// deletebyid
	public Employee deleteById(int id) {

		Optional<Employee> db = employeerepo.findById(id);
		if (db.isEmpty()) {
			throw new IdNotPresentException();

		} else {
			employeerepo.deleteById(id);
			return db.get();
		}

	}

	// fetchbyid
	public Employee getempbyId(int id) {
		Optional<Employee> db = employeerepo.findById(id);
		if (db.isPresent()) {
			return db.get();
		} else {
			throw new IdNotPresentException();
		}

	}

	// fetchby all
	public List<Employee> fetchAll() {
		return employeerepo.findAll();
	}

}
