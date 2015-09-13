package com.domain;

import com.pojo.Users;

public class ReDingDan {
	private String cids;
	private Users user;
	private double tprice;
	public String getCids() {
		return cids;
	}
	public void setCids(String cids) {
		this.cids = cids;
	}
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	public double getTprice() {
		return tprice;
	}
	public void setTprice(double tprice) {
		this.tprice = tprice;
	}
	public ReDingDan(String cids, Users user, double tprice) {
		super();
		this.cids = cids;
		this.user = user;
		this.tprice = tprice;
	}
	public ReDingDan() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
