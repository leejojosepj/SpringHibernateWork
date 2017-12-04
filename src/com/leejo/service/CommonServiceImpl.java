package com.leejo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leejo.dao.CommonDao;

import com.leejo.model.LoginAuth;

import com.leejo.model.UserLinks;
/**
 * 
 * @author Leejo Jose
 * @date 01-11-2017
 *
 */
@Service
public class CommonServiceImpl implements CommonService{

	@Autowired
	CommonDao commonDao;
	
	@Override
	public LoginAuth loginCheck(String uemail, String upass) {
		// TODO Auto-generated method stub
		return commonDao.loginCheck(uemail, upass);
	}

	@Override
	public List<UserLinks> getUserLinks(String utype) {
		// TODO Auto-generated method stub
		return commonDao.getUserLinks(utype);
	}

}
