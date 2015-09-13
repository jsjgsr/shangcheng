package com.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.UserDao;
import com.domain.ReDingDan;
import com.pojo.Cart;
import com.pojo.Product;
import com.pojo.Users;

@Service("cartService")
public class CartService {
	@Resource(name="CartDao")
	private com.dao.CartDao CartDao;

	public boolean add(Integer uid, int pid, int num) {
		// TODO Auto-generated method stub
		return CartDao.add(uid,pid,num);
	}

	public List<Cart> getCartList(Integer uid) {
		// TODO Auto-generated method stub
		return CartDao.getCartList(uid);
	}

	public ReDingDan creatDingDang(List<Integer> cids, Integer uid) {
		// TODO Auto-generated method stub
		return CartDao.creatDingDang(cids, uid);
	}

}
