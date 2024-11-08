package com.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.demo.beans.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	@Query(value="select * from myuser where username=:name",nativeQuery=true)
	User findByUserName(String username);
}
