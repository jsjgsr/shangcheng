package com.action;

import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.catalina.User;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.pojo.Product;
import com.pojo.Users;
import com.service.ProductService;
import com.service.UserService;

@Controller("userAction")
public class UserAction extends ActionSupport implements ModelDriven{
	@Resource(name="userService")
	private UserService userService;
	private Users user;
	private List<Product> productlist;
	@Resource(name="productService")
	private ProductService productService;
	
public ProductService getProductService() {
		return productService;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

public List<Product> getProductlist() {
		return productlist;
	}

	public void setProductlist(List<Product> productlist) {
		this.productlist = productlist;
	}

public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	

public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

public String userLogin() throws NoSuchAlgorithmException{
		
		String name  = user.getUname();
		String pwd = user.getUpwd();
		System.out.println("Action" + name + "        " + pwd);
		user = userService.getUser(name, pwd);
		if(user != null){
			if(!user.getUstate().equals("1")){
				return "userfalse";
			}
			Map<String, Object> session = ActionContext.getContext().getSession();//
			session.put("user", null);
			ActionContext.getContext().getSession() .put("user",user);
			productlist = productService.getlist();
			Map<String, Object> session1 = ActionContext.getContext().getSession();//
			session.put("state", null);
			ActionContext.getContext().getSession() .put("state","1");//普通用户
			return "loginSuccess";
		}else{
			System.out.println("等错误！！！！！！！！！！！！！！！！");
			return "error";
		}
	}

//保存用户信息！
	public String save() throws NoSuchAlgorithmException{
		System.out.println(user.getUname());
		//先进行用户名重复性的验证！
		String name  = user.getUname();
		if(userService.chongTu(name)){
			//如果有重复报错!
			return "rename";
		}
//		String url = user.getUrl();
//		String imgurl = uploadPic();
		System.out.println(user.getUname());
		System.out.println(user.getUpwd());
		userService.save(user);//获取前台的user对象
		return "reg_success";
	}

	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		if(user == null){
			user = new Users();
		}
		return user;
	}
	public String adminLogin() throws NoSuchAlgorithmException{
		
		String name  = user.getUname();
		String pwd = user.getUpwd();
		System.out.println("Action" + name + "        " + pwd);
		user = userService.getAdmin(name, pwd);
		if(user != null){
			Map<String, Object> session = ActionContext.getContext().getSession();//
			session.put("admin", null);
			ActionContext.getContext().getSession() .put("admin",user);
			Map<String, Object> session1 = ActionContext.getContext().getSession();//
			session.put("state", null);
			ActionContext.getContext().getSession() .put("state", "2" );//管理员
			return "adminloginSuccess_mainpage";
		}else{
			System.out.println("等错误！！！！！！！！！！！！！！！！");
			return "error";
		}
	}
}
