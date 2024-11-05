package com.demo.service;

import com.demo.beans.MyUser;

public interface LoginService {

	MyUser authenticateUser(String uname, String p1);

}
