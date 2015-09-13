package com.pojo;

/**
 * Uvc entity. @author MyEclipse Persistence Tools
 */

public class Uvc implements java.io.Serializable {

	// Fields

	private Integer uvcid;
	private Cart cart;
	private Users users;

	// Constructors

	/** default constructor */
	public Uvc() {
	}

	/** full constructor */
	public Uvc(Cart cart, Users users) {
		this.cart = cart;
		this.users = users;
	}

	// Property accessors

	public Integer getUvcid() {
		return this.uvcid;
	}

	public void setUvcid(Integer uvcid) {
		this.uvcid = uvcid;
	}

	public Cart getCart() {
		return this.cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

}