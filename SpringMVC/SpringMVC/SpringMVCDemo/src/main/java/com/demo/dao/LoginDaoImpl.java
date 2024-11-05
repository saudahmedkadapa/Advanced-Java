package com.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.demo.beans.MyUser;

@Repository
public class LoginDaoImpl implements LoginDao{
	 @Autowired
     JdbcTemplate jdbcTemplate;

	public MyUser validateUser(String uname, String p1) {
		try {
		MyUser u=jdbcTemplate.queryForObject("select uname,role from user where uname=? and password=?",
				new Object[] {uname,p1},
				BeanPropertyRowMapper.newInstance(MyUser.class));
		return u;
		}catch(EmptyResultDataAccessException e) {
			return null;
		}
	}
}
