package com.leejo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leejo.dao.AdminDao;
import com.leejo.model.AdminDetails;
import com.leejo.model.LoginAuth;
import com.leejo.model.Student;
/**
 * 
 * @author Leejo Jose
 * @date 01-11-2017
 *
 */
@Service
public class AdminServiceImpl implements AdminService{
    @Autowired
	AdminDao adminDao;

	@Override
	public AdminDetails getAdminData(Integer aid) {
		// TODO Auto-generated method stub
		return adminDao.getAdminData(aid);
	}

	@Override
	public void saveOrUpdate(Student student) {
		// TODO Auto-generated method stub
		 adminDao.saveOrUpdate(student);
	}

	@Override
	public void delete(Integer sid) {
		// TODO Auto-generated method stub
		adminDao.delete(sid);
		
	}

	@Override
	public void saveUpdate(Student student) {
		// TODO Auto-generated method stub
		adminDao.saveUpdate(student);
	}

	@Override
	public void saveOrUpdate(LoginAuth loginAuth) {
		// TODO Auto-generated method stub
		adminDao.saveOrUpdate(loginAuth);
	}

	@Override
	public void testDelete(Integer sid) {
		// TODO Auto-generated method stub
		adminDao.testDelete(sid);
	}

	@Override
	public Student getStudent(Integer studentId) {
		// TODO Auto-generated method stub
		return adminDao.getStudent(studentId);
	}

	@Override
	public Integer getMaxStudentId() {
		// TODO Auto-generated method stub
		return adminDao.getMaxStudentId();
	}

	@Override
	public void deleteLogin(Integer studentId) {
		// TODO Auto-generated method stub
		adminDao.deleteLogin(studentId);
	}

	@Override
	public void updateLogin(String email,Integer studentId,String type) {
		// TODO Auto-generated method stub
		adminDao.updateLogin(email,studentId,type);
	}


    
	
}
