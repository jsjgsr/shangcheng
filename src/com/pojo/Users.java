package com.pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * Users entity. @author MyEclipse Persistence Tools
 */

public class Users implements java.io.Serializable {

	// Fields

	private Integer uid;
	private String uname;
	private String upwd;
	private String uaddress;
	private String utel;
	private String ustate;
	private Set uvcs = new HashSet(0);

	// Constructors

	/** default constructor */
	public Users() {
	}

	/** full constructor */
	public Users(String uname, String upwd, String uaddress, String utel,
			String ustate, Set uvcs) {
		this.uname = uname;
		this.upwd = upwd;
		this.uaddress = uaddress;
		this.utel = utel;
		this.ustate = ustate;
		this.uvcs = uvcs;
	}

	// Property accessors

	public Integer getUid() {
		return this.uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getUname() {
		return this.uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUpwd() {
		return this.upwd;
	}

	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}

	public String getUaddress() {
		return this.uaddress;
	}

	public void setUaddress(String uaddress) {
		this.uaddress = uaddress;
	}

	public String getUtel() {
		return this.utel;
	}

	public void setUtel(String utel) {
		this.utel = utel;
	}

	public String getUstate() {
		return this.ustate;
	}

	public void setUstate(String ustate) {
		this.ustate = ustate;
	}

	public Set getUvcs() {
		return this.uvcs;
	}

	public void setUvcs(Set uvcs) {
		this.uvcs = uvcs;
	}

}