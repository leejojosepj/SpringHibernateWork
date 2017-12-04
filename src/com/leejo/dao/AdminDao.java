package com.leejo.dao;

import com.leejo.model.AdminDetails;
import com.leejo.model.LoginAuth;
import com.leejo.model.Student;
/**
 * 
 * @author Leejo Jose
 * @date 01-11-2017
 *
 */
public interface AdminDao {
	//spring 4 demo leejo jose
	public AdminDetails getAdminData(Integer aid);
	public void saveOrUpdate(Student student);
	public void delete(Integer sid);
	public void saveUpdate(Student student);
	public void saveOrUpdate(LoginAuth loginAuth);
	void testDelete(Integer sid);
	public Student getStudent(Integer studentId);
	public Integer getMaxStudentId();
	public void deleteLogin(Integer studentId);
	public void updateLogin(String email,Integer studentId,String type);
}
