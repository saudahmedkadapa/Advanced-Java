package com.demo.service;

import java.util.List;

import com.demo.beans.Employee;

public interface EmployeeService {

	void closeMyConnection();

	void addnewEmployee();

	List<Employee> getAllEmployee();

	boolean deleteById(int id);

	boolean modifyEmployee(int id, String nm, double sal);

	Employee getById(int id);

	List<Employee> sortedEmployee();

}
