package com.leejo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author Leejo Jose
 * @date 01-11-2017
 *
 */

@Entity
@Table(name= "user_link_table")
public class UserLinks {
	//spring 4 demo leejo jose
	Integer lid;
	String linkName;
	String linkAction;
	String userType;
	String status;
	Integer orderNum;
	
	@Id
	@GeneratedValue
	@Column(name = "lid")
	public Integer getLid() {
		return lid;
	}
	public void setLid(Integer lid) {
		this.lid = lid;
	}
	
	@Column(name = "lname")
	public String getLinkName() {
		return linkName;
	}
	public void setLinkName(String linkName) {
		this.linkName = linkName;
	}
	
	
	@Column(name = "laction")
	public String getLinkAction() {
		return linkAction;
	}
	public void setLinkAction(String linkAction) {
		this.linkAction = linkAction;
	}
	@Column(name = "usertype")
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	
	@Column(name = "status")
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Column(name = "ordernum")
	public Integer getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}
	
	
	

}
