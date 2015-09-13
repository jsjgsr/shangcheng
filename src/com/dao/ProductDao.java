package com.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Component;



import org.springframework.transaction.annotation.Transactional;











import com.myexception.UserException;
import com.pojo.Product;
import com.pojo.Users;

@Component("ProductDao")
public class ProductDao extends BaseDao{

	public List<Product> getlist() {
		// TODO Auto-generated method stub
		List<Product> data = new ArrayList<Product>();
		Session session = super.getSession();
		String hql = "from Product p where p.pstate = ?";
		Query query = session.createQuery(hql);
		query.setString(0, "1");
		data = query.list();
		System.out.println(data.size());
		
		return data;
	}

	public boolean add(String pname, double price, String info, String url) {
		// TODO Auto-generated method stub
		Product p = new Product(pname, price, info, url, "1");
		Session session = super.getSession();
		try {
			session.save(p);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		
	}

	public boolean del(int pid) {
		// TODO Auto-generated method stub
		Session session = super.getSession();
		String hql = "update Product p set p.pstate = ? where p.pid = ?";
		Query q = session.createQuery(hql);
		q.setString(0, "2");
		q.setInteger(1, pid);
		int r = q.executeUpdate(); 
		if(r == 1){
			return true;
		}
		return false;
	}

	public Product getinfo(Integer pid) {
		// TODO Auto-generated method stub
		List<Product> data = new ArrayList<Product>();
		Session session = super.getSession();
		String hql = "from Product p where p.pid = ?";
		Query query = session.createQuery(hql);
		query.setInteger(0, pid);
		data = query.list();
		System.out.println(data.size());
		return data.get(0);
	}

	
	
}
