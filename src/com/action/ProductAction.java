package com.action;

import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.pojo.Product;
import com.pojo.Users;
import com.service.ProductService;
import com.service.UserService;

@Controller("productAction")
public class ProductAction extends ActionSupport implements ModelDriven{
	@Resource(name="productService")
	private ProductService productrService;
	private Product product;
	private Product reproduct;
	private String pid;
	private List<Product> productlist;
	
	
	public List<Product> getProductlist() {
		return productlist;
	}
	public void setProductlist(List<Product> productlist) {
		this.productlist = productlist;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		if(product == null){
			product = new Product();
		}
		return product;
	}
	public ProductService getProductrService() {
		return productrService;
	}
	public void setProductrService(ProductService productrService) {
		this.productrService = productrService;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	
	public String add(){
		String pname = product.getPname();
		double price = product.getPrice();
		String info = product.getInfo();
		String url = product.getUrl();
		if(productrService.add(pname,price,info,url)){
			return "proaddsuccess";
		}
		return "error";
	}
	public String delete(){
		System.out.println("产品id====" + product.getPid());
		if(productrService.del(product.getPid())){
			return "prodelsuccess";
		}
		return "error";
	}
	public String findall(){
		productlist = productrService.getlist();
		return "loginSuccess";
	}
	public String info(){
		product = productrService.getinfo(product.getPid());
		return "proinfo";
	}
	public String getlist(){
		System.out.println("执行了");
		productlist = productrService.getlist();
		System.out.println(productlist.get(0).getPname());
		return "getAll";
	}
}
