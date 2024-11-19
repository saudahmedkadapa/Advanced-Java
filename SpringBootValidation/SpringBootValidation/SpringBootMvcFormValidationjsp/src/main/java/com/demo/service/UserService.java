package com.demo.service;

import java.util.List;

import javax.validation.Valid;

import com.demo.beans.MyUser;

public interface UserService {

	void addnewUSer(@Valid MyUser myUser);

	List<MyUser> getAllUSers();

	MyUser getById(String name);

	void updateUSer(@Valid MyUser myUser);

	void deleteUser(String name);

}
