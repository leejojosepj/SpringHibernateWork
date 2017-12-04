package com.leejo.service;

import java.util.List;

import com.leejo.model.LoginAuth;

import com.leejo.model.UserLinks;
/**
 * 
 * @author Leejo Jose
 * @date 01-11-2017
 *
 */
public interface CommonService {
	//spring 4 demo leejo jose
	public LoginAuth loginCheck(String uemail,String upass);
	
	public List<UserLinks> getUserLinks(String utype);
}
