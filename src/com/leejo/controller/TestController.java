package com.leejo.controller;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.leejo.bo.UserDetails;

/**
 * 
 * @author Leejo Jose
 * @date 01-11-2017
 *
 */

@Controller
@Scope("session")
public class TestController {

	
	
	@Autowired
	private UserDetails userDetails;
	
	@RequestMapping(value = "/", method = { RequestMethod.POST, RequestMethod.GET })
	private ModelAndView schoolBusStops(HttpServletRequest request) {
		ModelAndView model = new ModelAndView("login");
		
		return model;
	}
	//spring 4 demo leejo jose
	@RequestMapping(value = "loginCheck", method = { RequestMethod.POST, RequestMethod.GET })
	private ModelAndView loginCheck(HttpServletRequest request) {
		ModelAndView model = null;
		
		String uname=request.getParameter("uname").toString();
		String pass=request.getParameter("pass").toString();
		
		Boolean flag=userDetails.authenticateUser(uname, pass);
		
		if(flag){
			HttpSession session = request.getSession(true);
			session.setAttribute("loggedInUser", uname);
			
			if(userDetails.getStatus()==0){
				
				if(userDetails.getUtype().equals("admin")){
					System.out.println("admin");
					model = new ModelAndView("redirect:/adminHome");
				}
				else if(userDetails.getUtype().equals("student")){
					System.out.println("student");
					model = new ModelAndView("redirect:/studentHome");
				}
				
				
				
			}else{
				System.out.println("blocked");
			}
			
		}
		else{
			System.out.println("Invalid user");
			model = new ModelAndView("login");
		}
		
//		List<Student> studentList=studentService.getAllStudents();
		
		return model;
	}
	
	
	@RequestMapping(value = "/logout")
	public ModelAndView logout(HttpServletRequest request) {
		request.getSession().invalidate();
		ModelAndView model = new ModelAndView("login");
		
		return model;
	}
	
	@RequestMapping(value = "interceptorExample", method = { RequestMethod.POST, RequestMethod.GET })
	private ModelAndView interceptorExample(HttpServletRequest request) {
		ModelAndView model = new ModelAndView("interceptorExamplePage");
		
		return model;
	}
}
