package com.demo.dao;

import java.util.List;

import com.demo.beans.Employee;

public interface EmployeeDao {

	void closeMyConnection();

	void saveEmp(Employee e1);

	List<Employee> findAllEmp();

	boolean removeById(int id);

	boolean updateEmployee(int id, String nm, double sal);

	Employee findById(int id);

	List<Employee> sortByName();

}
