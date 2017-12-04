package com.leejo.dao;

import java.util.List;

import com.leejo.model.Student;

/**
 * 
 * @author Leejo Jose
 * @date 01-11-2017
 *
 */

public interface StudentDao {
	//spring 4 demo leejo jose
	public List<Student> getAllStudents();
	public Student getStudentData(Integer sid);
}
