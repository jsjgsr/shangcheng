package com.dao;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Component;



import org.springframework.transaction.annotation.Transactional;

import com.domain.ReDingDan;
import com.myexception.UserException;
import com.pojo.Cart;
import com.pojo.Dingdan;
import com.pojo.Product;
import com.pojo.Users;
import com.pojo.Uvc;

@Component("CartDao")
public class CartDao extends BaseDao{

	public boolean add(Integer uid, int pid, int num) {
		// TODO Auto-generated method stub
		Session session = super.getSession();
		String hql = "from Product p where p.pid = ?";
		Query query = session.createQuery(hql);
		query.setInteger(0, pid );
		List<Product> list = new ArrayList<Product>();
		list = query.list();
		Calendar calendar = Calendar.getInstance();
		Timestamp time = new Timestamp(calendar.getTimeInMillis());
		Cart cart = new Cart(pid, list.get(0).getPname(), num, list.get(0).getPrice()*num,time);
		session.save(cart);
		System.out.println("时间=====" + cart.getAddtime());
		
		String hql1 = "from Users u where u.uid = ?";
		Query query1 = session.createQuery(hql1);
		System.out.println(uid);
		query1.setInteger(0, uid );
		List<Users> list1 = new ArrayList<Users>();
		list1 = query1.list();
		System.out.println(list1.size());
		
		Users u = list1.get(0);
		
		Uvc uvc = new Uvc(cart, u);
		try {
			session.save(uvc);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		
	}

	public List<Cart> getCartList(Integer uid) {
		// TODO Auto-generated method stub
		Session session = super.getSession();
		System.out.println("传来的uid是=====" + uid);
		String hql  = "from Uvc uc where uc.users.uid = ?  ";
		Query q = session.createQuery(hql);
		q.setInteger(0, uid);
		List<Uvc> list  = new ArrayList<Uvc>();
		list = (List<Uvc>)q.list();
		List<Cart> data = new ArrayList<Cart>();
		for (Uvc uc : list) {
			data.add(uc.getCart());
		}
		System.out.println("cart大小-============" + data.size());
		return data;
	}
//	public List<Product> getlist() {
//		// TODO Auto-generated method stub
//		List<Product> data = new ArrayList<Product>();
//		Session session = super.getSession();
//		String hql = "from Product p where p.pstate = ?";
//		Query query = session.createQuery(hql);
//		query.setString(0, "1");
//		data = query.list();
//		System.out.println(data.size());
//		
//		return data;
//	}
//
//	public boolean add(String pname, double price, String info, String url) {
//		// TODO Auto-generated method stub
//		Product p = new Product(pname, price, info, url, "1");
//		Session session = super.getSession();
//		try {
//			session.save(p);
//			return true;
//		} catch (Exception e) {
//			// TODO: handle exception
//			return false;
//		}
//		
//	}
//
//	public boolean del(int pid) {
//		// TODO Auto-generated method stub
//		Session session = super.getSession();
//		String hql = "update Product p set p.pstate = ? where p.pid = ?";
//		Query q = session.createQuery(hql);
//		q.setString(0, "2");
//		q.setInteger(1, pid);
//		int r = q.executeUpdate(); 
//		if(r == 1){
//			return true;
//		}
//		return false;
//	}
//
//	public Product getinfo(Integer pid) {
//		// TODO Auto-generated method stub
//		List<Product> data = new ArrayList<Product>();
//		Session session = super.getSession();
//		String hql = "from Product p where p.pid = ?";
//		Query query = session.createQuery(hql);
//		query.setInteger(0, pid);
//		data = query.list();
//		System.out.println(data.size());
//		return data.get(0);
//	}

	public ReDingDan creatDingDang(List<Integer> cids, Integer uid) {
		// TODO Auto-generated method stub
		String ids = "";
		int l = cids.size();
		int i = 1;
		List<Cart> data = new ArrayList<Cart>();
		for (Integer cid : cids) {
			if(i < l){
				ids = ids + cid + ",";
			}
			if(i == l){
				ids = ids + cid;
			}
			i++;
			Session s = super.getSession();
			String hql  = "from Cart c where c.cid = ?";
			Query q = s.createQuery(hql);
			q.setInteger(0, cid);
			List<Cart> cartlist = new ArrayList<Cart>();
			cartlist = (List<Cart>) q.list();
			Cart c = cartlist.get(0);
			data.add(c);
		}
		Double totlprice = 0.0;
		for (Cart cart : data) {
			totlprice = totlprice + cart.getCprice();
		}
		Session s1 = super.getSession();
		String hql  = "from Users u where u.uid = ?";
		Query q = s1.createQuery(hql);
		q.setInteger(0, uid);
		Users user = (Users)q.list().get(0);
		ReDingDan rdd = new ReDingDan(ids, user, totlprice);
		
		Session s2 = super.getSession();
		Calendar calendar = Calendar.getInstance();
		Timestamp time = new Timestamp(calendar.getTimeInMillis());
		Dingdan dd = new Dingdan(uid, ids, totlprice, user.getUaddress(), time, "0");
		
		s2.save(dd);
		
		System.out.println("获取的长度=====" + data.size());
		return rdd;
	}

	
	
}
