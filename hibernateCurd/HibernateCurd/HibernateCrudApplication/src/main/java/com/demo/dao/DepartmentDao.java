package com.demo.dao;

import java.util.List;

import com.demo.beans.Department;

public interface DepartmentDao {

	void save(Department d);

	boolean removeById(int id);

	boolean updateById(int id, String nm, String loc);

	Department findById(int id);

	List<Department> findAll();

}
