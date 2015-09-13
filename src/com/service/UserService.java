package com.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.UserDao;
import com.pojo.Users;

@Service("userService")
public class UserService {
	@Resource(name="UserDao")
	private UserDao UserDao;

	public UserDao getUserDao() {
		return UserDao;
	}

	public void setUserDao(UserDao userDao) {
		UserDao = userDao;
	}

	public Users getUser(String name, String pwd) {
		// TODO Auto-generated method stub
		return UserDao.getUser(name, pwd);
	}

	public String save(Users user) {
		// TODO Auto-generated method stub
		return UserDao.save(user);
	}

	public boolean chongTu(String name) {
		// TODO Auto-generated method stub
		return UserDao.chongTu(name);
	}

	public Users getAdmin(String name, String pwd) {
		// TODO Auto-generated method stub
		return UserDao.getAdmin(name,pwd);
	}
	
	
}
