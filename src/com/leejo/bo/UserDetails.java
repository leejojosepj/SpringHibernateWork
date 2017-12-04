package com.leejo.bo;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.leejo.model.LoginAuth;

import com.leejo.model.UserLinks;
import com.leejo.service.CommonService;
/**
 * 
 * @author Leejo Jose
 * @date 01-11-2017
 *
 */
@Component
@Scope("session")
public class UserDetails {
	
	
	private int studentId;
	private String studentName;
	private String studentPass;
	private String studentEmail;
	private String studentPhone;
	private int status;
	
	private int loginid;
	private String utype;
	private int userId;
	
	
	private String name;

	
	@Autowired
	private CommonService commonService;

	
	//
	List<UserLinks> userLinks=null;
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<UserLinks> getUserLinks() {
		return userLinks;
	}
	public void setUserLinks(List<UserLinks> userLinks) {
		this.userLinks = userLinks;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentPass() {
		return studentPass;
	}
	public void setStudentPass(String studentPass) {
		this.studentPass = studentPass;
	}
	public String getStudentEmail() {
		return studentEmail;
	}
	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}
	public String getStudentPhone() {
		return studentPhone;
	}
	public void setStudentPhone(String studentPhone) {
		this.studentPhone = studentPhone;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getLoginid() {
		return loginid;
	}
	public void setLoginid(int loginid) {
		this.loginid = loginid;
	}
	public String getUtype() {
		return utype;
	}
	public void setUtype(String utype) {
		this.utype = utype;
	}
	
	//
	public Boolean authenticateUser(String uemail,String upass)
	{
		LoginAuth loginAuth=commonService.loginCheck(uemail, upass);
		
		if(loginAuth != null){
			
			setLoginid(loginAuth.getLoginId());
			setUtype(loginAuth.getUtype());
			setUserId(loginAuth.getUserId());
			setStudentEmail(loginAuth.getEmailId());
			setStudentPass(loginAuth.getPass());
			setStatus(loginAuth.getStatus());
			userLinks=commonService.getUserLinks(getUtype());
			
			
			
			return true;
		}
		else{
		
		return false;
		}
	}	
	

}
