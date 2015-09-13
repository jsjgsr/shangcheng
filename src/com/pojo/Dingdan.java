package com.pojo;

import java.sql.Timestamp;

/**
 * Dingdan entity. @author MyEclipse Persistence Tools
 */

public class Dingdan implements java.io.Serializable {

	// Fields

	private Integer ddid;
	private Integer uid;
	private String cids;
	private Double tprice;
	private String address;
	private Timestamp dtime;
	private String state;

	// Constructors

	/** default constructor */
	public Dingdan() {
	}

	/** full constructor */
	public Dingdan(Integer uid, String cids, Double tprice, String address,
			Timestamp dtime, String state) {
		this.uid = uid;
		this.cids = cids;
		this.tprice = tprice;
		this.address = address;
		this.dtime = dtime;
		this.state = state;
	}

	// Property accessors

	public Integer getDdid() {
		return this.ddid;
	}

	public void setDdid(Integer ddid) {
		this.ddid = ddid;
	}

	public Integer getUid() {
		return this.uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getCids() {
		return this.cids;
	}

	public void setCids(String cids) {
		this.cids = cids;
	}

	public Double getTprice() {
		return this.tprice;
	}

	public void setTprice(Double tprice) {
		this.tprice = tprice;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Timestamp getDtime() {
		return this.dtime;
	}

	public void setDtime(Timestamp dtime) {
		this.dtime = dtime;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

}