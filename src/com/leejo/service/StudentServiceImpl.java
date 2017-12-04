package com.leejo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leejo.dao.StudentDao;
import com.leejo.model.Student;
/**
 * 
 * @author Leejo Jose
 * @date 01-11-2017
 *
 */
@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
    StudentDao studentDao;
	
	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		return studentDao.getAllStudents();
	}

	@Override
	public Student getStudentData(Integer sid) {
		// TODO Auto-generated method stub
		return studentDao.getStudentData(sid);
	}

}
