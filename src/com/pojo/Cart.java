package com.pojo;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Cart entity. @author MyEclipse Persistence Tools
 */

public class Cart implements java.io.Serializable {

	// Fields

	private Integer cid;
	private Integer pid;
	private String pname;
	private Integer num;
	private Double cprice;
	private Timestamp addtime;
	private Set uvcs = new HashSet(0);

	// Constructors

	/** default constructor */
	public Cart() {
	}

	/** full constructor */
	public Cart(Integer pid, String pname, Integer num, Double cprice,
			Timestamp addtime, Set uvcs) {
		this.pid = pid;
		this.pname = pname;
		this.num = num;
		this.cprice = cprice;
		this.addtime = addtime;
		this.uvcs = uvcs;
	}

	// Property accessors

	public Cart(Integer pid, String pname, Integer num, Double cprice,
			Timestamp addtime) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.num = num;
		this.cprice = cprice;
		this.addtime = addtime;
	}

	public Integer getCid() {
		return this.cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public Integer getPid() {
		return this.pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getPname() {
		return this.pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public Integer getNum() {
		return this.num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public Double getCprice() {
		return this.cprice;
	}

	public void setCprice(Double cprice) {
		this.cprice = cprice;
	}

	public Timestamp getAddtime() {
		return this.addtime;
	}

	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}

	public Set getUvcs() {
		return this.uvcs;
	}

	public void setUvcs(Set uvcs) {
		this.uvcs = uvcs;
	}

}