package com.demo.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.beans.MyUser;
import com.demo.dao.UserDao;

@Service
public class UserServiceImpl implements UserService
{
  @Autowired
  private UserDao userDao;

@Override
public void addnewUSer(@Valid MyUser myUser) {
	userDao.save(myUser);
	
}

@Override
public List<MyUser> getAllUSers() {
	return userDao.findAll();
}

@Override
public MyUser getById(String name) {
	Optional<MyUser> op=userDao.findById(name);
	//orElse will return value if present else returns null;
	return op.orElse(null);
}

@Override
public void updateUSer(@Valid MyUser myUser) {
	Optional<MyUser> op=userDao.findById(myUser.getName());
	if(op.isPresent()) {
		MyUser u1=op.get();
		u1.setEmail(myUser.getEmail());
		u1.setNote(myUser.getNote());
		u1.setIncome(myUser.getIncome());
		userDao.save(u1);
	}
	
}

@Override
public void deleteUser(String name) {
	userDao.deleteById(name);
	
}
  
  
}
