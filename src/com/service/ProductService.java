package com.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.UserDao;
import com.pojo.Product;
import com.pojo.Users;

@Service("productService")
public class ProductService {
	@Resource(name="ProductDao")
	private com.dao.ProductDao ProductDao;

	public com.dao.ProductDao getProductDao() {
		return ProductDao;
	}

	public void setProductDao(com.dao.ProductDao productDao) {
		ProductDao = productDao;
	}

	public List<Product> getlist() {
		// TODO Auto-generated method stub
		return ProductDao.getlist();
	}

	public boolean add(String pname, double price, String info, String url) {
		// TODO Auto-generated method stub
		return ProductDao.add(pname,price,info,url);
	}

	public boolean del(int pid) {
		// TODO Auto-generated method stub
		return ProductDao.del(pid);
	}

	public Product getinfo(Integer pid) {
		// TODO Auto-generated method stub
		return ProductDao.getinfo(pid);
	}

	
	
}
