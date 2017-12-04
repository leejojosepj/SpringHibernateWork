package com.leejo.controller;

import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.leejo.bo.UserDetails;

import com.leejo.model.Student;
import com.leejo.service.StudentService;
/**
 * 
 * @author Leejo Jose
 * @date 01-11-2017
 *
 */
@Controller
@Scope("session")
public class StudentController {
	
	@Autowired
	private UserDetails userDetails;
	@Autowired
	private StudentService studentService;
	//spring 4 demo leejo jose
	@RequestMapping(value = "/studentHome")
	public ModelAndView parentHome(HttpServletRequest request)
			throws ParseException {
		ModelAndView model = new ModelAndView("studentHome");
		Student studentDetails=studentService.getStudentData(userDetails.getUserId());
		userDetails.setName(studentDetails.getSname());
		model.addObject("userDetails", userDetails);
		model.addObject("studentDetails", studentDetails);
				return model;
	}
	
	

}
