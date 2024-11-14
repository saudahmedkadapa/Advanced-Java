package com.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.beans.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer>{
	@Query(value="select * from myuser24 where username = :username",nativeQuery=true)
	User findByUserName(@Param("username") String username);
}
