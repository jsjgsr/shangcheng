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

@Component("DingDanDao")
public class DingDanDao extends BaseDao{

	public List<Dingdan> getlist(Integer uid) {
		// TODO Auto-generated method stub
		List<Dingdan> data = new ArrayList<Dingdan>();
		Session s = super.getSession();
		String hql = "from Dingdan d where d.uid = ?";
		Query q = s.createQuery(hql);
		q.setInteger(0, uid);
		List<Dingdan> list = new ArrayList<Dingdan>();
		list = q.list();
//		for (Dingdan dingdan : list) {
//			data.add(dingdan);
//		}
		return list;
	}

	public boolean zhifu(int ddid) {
		// TODO Auto-generated method stub
		Session s = super.getSession();
		String hql = "update Dingdan d set d.state = ? where d.ddid = ?";
		Query q = s.createQuery(hql);
		q.setString(0, "1");
		q.setInteger(1, ddid);
		int r = q.executeUpdate();
		if(r == 1){
			return true;
		}
		return false;
	}

	

	
	
}
