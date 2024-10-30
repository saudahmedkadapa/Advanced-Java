package com.demo.service;

import java.util.List;

import com.demo.beans.Department;

public interface DepartmentService {

	void addnewDepartment();

	boolean deleteById(int id);

	boolean modifyDepartment(int id, String nm, String loc);

	Department getById(int id);

	List<Department> getAllDepartment();

}
