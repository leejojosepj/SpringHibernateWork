package com.leejo.service;

import java.util.List;


import com.leejo.model.Student;
/**
 * 
 * @author Leejo Jose
 * @date 01-11-2017
 *
 */


public interface StudentService {
	//spring 4 demo leejo jose
	public List<Student> getAllStudents();

	public Student getStudentData(Integer sid);
}
