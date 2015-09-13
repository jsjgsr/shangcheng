package com.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Component;



import org.springframework.transaction.annotation.Transactional;






import com.myexception.UserException;
import com.pojo.Users;

@Component("UserDao")
public class UserDao extends BaseDao{

	@Transactional
	public Users getUser(String name, String pwd) {
		// TODO Auto-generated method stub
		Users user = new Users();
		Session session = super.getSession();
		System.out.println("用户名=   " + name);
		Query query = session.createQuery("from Users where uname = ? and upwd = ?");
		query.setString(0, name);
		query.setString(1, pwd);
		List<Users> list = query.list();
		System.out.println("大小===="  + list.size());
		if(list.size()==0){
			return null;
		}else{
			return list.get(0);
		}
	}

	public String save(Users user){
		try{
			getSession().save(user);
			return "success";
		}catch(Exception e){
			return "false";
		}
	}

	public boolean chongTu(String name) {
		// TODO Auto-generated method stub
		Users user = new Users();
		Session session = super.getSession();
		Query query = session.createQuery("from Users where uname = ?");
		query.setString(0, name);
		
		List<Users> list = query.list();
		if(list.size()!=0){//有重复的
			return true;
		}else{//没重复的
		return false;
		}
	}

	public Users getAdmin(String name, String pwd) {
		// TODO Auto-generated method stub
		Users user = new Users();
		Session session = super.getSession();
		System.out.println("用户名=   " + name);
		Query query = session.createQuery("from Users where uname = ? and upwd = ? and ustate = ?");
		query.setString(0, name);
		query.setString(1, pwd);
		query.setString(2, "2");
		List<Users> list = query.list();
		if(list.size()==0){
			return null;
		}else{
			return list.get(0);
		}
	}

	
	
}
