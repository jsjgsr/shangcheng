package com.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.UserDao;
import com.domain.ReDingDan;
import com.pojo.Cart;
import com.pojo.Dingdan;
import com.pojo.Product;
import com.pojo.Users;

@Service("dingdanService")
public class DingDanService {
	@Resource(name="DingDanDao")
	private com.dao.DingDanDao DingDanDao;

	

	public List<Dingdan> getlsit(Integer uid) {
		// TODO Auto-generated method stub
		return DingDanDao.getlist(uid);
	}



	public boolean zhifu(int ddid) {
		// TODO Auto-generated method stub
		return DingDanDao.zhifu(ddid);
	}


}
