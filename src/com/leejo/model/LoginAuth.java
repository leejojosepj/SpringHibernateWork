package com.leejo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 
 * @author Leejo Jose
 * @date 01-11-2017
 *
 */

@Entity
@Table(name = "login_table")
public class LoginAuth {
	//spring 4 demo leejo jose
	Integer loginId;
	Integer userId;
	String emailId;
	String pass;
	String utype;
	Integer status;
	
//	Student student;
	
	@Id
	@GeneratedValue
	@Column(name = "lid")
	public Integer getLoginId() {
		return loginId;
	}
	public void setLoginId(Integer loginId) {
		this.loginId = loginId;
	}
	
	@Column(name = "uid")
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	@Column(name = "uemail")
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	@Column(name = "pass")
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	@Column(name = "utype")
	public String getUtype() {
		return utype;
	}
	public void setUtype(String utype) {
		this.utype = utype;
	}
	
	@Column(name = "status")
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
//	@OneToOne
//    @JoinColumn(name="uid")
//	public Student getStudent() {
//		return student;
//	}
//	public void setStudent(Student student) {
//		this.student = student;
//	}
	
	

}
