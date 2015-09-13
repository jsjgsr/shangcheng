package com.action;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.domain.ReDingDan;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.pojo.Cart;
import com.pojo.Dingdan;
import com.pojo.Product;
import com.pojo.Users;
import com.service.CartService;
import com.service.DingDanService;
import com.service.ProductService;
import com.service.UserService;

@Controller("dingdanAction")
public class DingDanAction extends ActionSupport implements ModelDriven{
	@Resource(name="dingdanService")
	private DingDanService dingdanService;
	private List<Dingdan> ddan;
	private int ddid;
	

	public int getDdid() {
		return ddid;
	}
	public void setDdid(int ddid) {
		this.ddid = ddid;
	}
	public DingDanService getDingdanService() {
		return dingdanService;
	}
	public void setDingdanService(DingDanService dingdanService) {
		this.dingdanService = dingdanService;
	}
	public List<Dingdan> getDdan() {
		return ddan;
	}
	public void setDdan(List<Dingdan> ddan) {
		this.ddan = ddan;
	}
	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return null;
	}
	public String ddlist(){
		HttpSession session=ServletActionContext.getRequest().getSession();//---得到Session
		Users user=(Users) session.getAttribute("user"); //强转成
		ddan = dingdanService.getlsit(user.getUid());
		System.out.println("订单的长度===========" + ddan.size() + "     " + ddan.get(0).getState());
		return "dingdanlist";
	}
	
	public String zhifu(){
		System.out.println("订单号==========" + ddid);
		if(dingdanService.zhifu(ddid)){
			return "success";
		}
		return "error";
		
	}
}
