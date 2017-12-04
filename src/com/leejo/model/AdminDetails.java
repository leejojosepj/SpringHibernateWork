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
@Table(name = "admin_table")
public class AdminDetails {
	//spring 4 demo leejo jose
	Integer adminId;
	String adminName;
	String adminEmail;
	String adminPass;
	Integer status;
	
	@Id
	@GeneratedValue
	@Column(name = "aid")
	public Integer getAdminId() {
		return adminId;
	}
	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}
	
	@Column(name = "aname")
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	
	@Column(name = "aemail")
	public String getAdminEmail() {
		return adminEmail;
	}
	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}
	
	
	@Column(name = "apass")
	public String getAdminPass() {
		return adminPass;
	}
	public void setAdminPass(String adminPass) {
		this.adminPass = adminPass;
	}
	
	@Column(name = "status")
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	
	

}
