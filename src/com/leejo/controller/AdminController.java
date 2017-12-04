package com.leejo.controller;

import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.leejo.bo.UserDetails;
import com.leejo.model.Address;
import com.leejo.model.AdminDetails;
import com.leejo.model.LoginAuth;
import com.leejo.model.Student;
import com.leejo.service.AdminService;
import com.leejo.service.StudentService;
/**
 * 
 * @author Leejo Jose
 * @date 01-11-2017
 *
 */
@Controller
@Scope("session")
public class AdminController {
	
	@Autowired
	private UserDetails userDetails;
	@Autowired
	private AdminService adminService;
	@Autowired
	private StudentService studentService;
	
	@RequestMapping(value = "/adminHome")
	public ModelAndView parentHome(HttpServletRequest request)
			throws ParseException {
		ModelAndView model = new ModelAndView("studentAdminHome");
		AdminDetails adminDetails=adminService.getAdminData(userDetails.getUserId());
		userDetails.setName(adminDetails.getAdminName());
		model.addObject("userDetails", userDetails);
		
				return model;
	}
	//spring 4 demo leejo jose
	@RequestMapping(value = "/viewAllStudent")
	public ModelAndView viewAllStudent(HttpServletRequest request)
			throws ParseException {
		ModelAndView model = new ModelAndView("studentAdminViewAllStudent");
//		Student studentDetails=studentService.getStudentData(userDetails.getUserId());
		List<Student> students=studentService.getAllStudents();
//		userDetails.setName(studentDetails.getSname());
		model.addObject("userDetails", userDetails);
		model.addObject("students", students);
				return model;
	}
	
	//exaple leejo work -- ResponseBody return
	@RequestMapping(value = "/updateStudent", method = RequestMethod.GET)
	public @ResponseBody String updateStudent(@RequestParam("studentPhone") String studentPhone,@RequestParam("studentEmail") String studentEmail,@RequestParam("studentId") int studentId,  @RequestParam("studentName") String studentName,@RequestParam("studentPass") String studentPass,@RequestParam("studentAddressStreet") String studentAddressStreet,@RequestParam("studentAddressCity") String studentAddressCity,@RequestParam("studentAddressCountry") String studentAddressCountry,@RequestParam("studentAddressId") Integer studentAddressId,
			HttpSession session ,RedirectAttributes redirectAttributes) {
		
		Student s=new Student();
		s.setSid(studentId);
		s.setSphone(studentPhone);
		s.setSname(studentName);
		s.setSpassword(studentPass);
		s.setSemail(studentEmail);
		s.setStatus(0);
		
		
		Address address=new Address();
		address.setAddressId(studentAddressId);
		address.setCity(studentAddressCity);
		address.setCountry(studentAddressCountry);
		address.setStreet(studentAddressStreet);
		
		s.setStudentAddress(address);
		adminService.saveUpdate(s);

		//to update logintable
		adminService.updateLogin(studentEmail, studentId, "student");
		//
		System.out.println("Hit");
		return "Hit";
	}
	
	@RequestMapping(value = "/deleteStudent", method = RequestMethod.GET)
	public ModelAndView deleteStudent(@RequestParam("studentId") int studentId,
			HttpSession session ,RedirectAttributes redirectAttributes) {
		//testDelete() will delete the orphan entries in address table too,
		adminService.testDelete(studentId);
		adminService.deleteLogin(studentId);
		return new ModelAndView("redirect:/viewAllStudent");
	}

	
//	@RequestMapping(value = "/saveStudentAdmin", method = RequestMethod.GET)
//	public ModelAndView saveStudentAdmin(@RequestParam("studentId") int studentId,
//			HttpSession session ,RedirectAttributes redirectAttributes) {
//		
//		adminService.delete(studentId);
//		
//		return new ModelAndView("redirect:/viewAllStudent");
//	}
	
	@RequestMapping(value = "/addStudent")
	public ModelAndView addStudent(HttpServletRequest request,@ModelAttribute("student") Student student)
			throws ParseException {
		
		ModelAndView model = new ModelAndView("studentAdminAddStudent");
		model.addObject("userDetails", userDetails);
		
				return model;
	}
	
	@RequestMapping(value = "/saveNewStudentAdmin",method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView saveNewStudentAdmin(HttpServletRequest request,@ModelAttribute("student") Student student,
			HttpSession session ,RedirectAttributes redirectAttributes) {
	
		student.setStatus(0);

		Address address=new Address();
		address.setCity(student.getCity());
		address.setCountry(student.getCountry());
		address.setStreet(student.getStreet());
		student.setStudentAddress(address);
	
		adminService.saveUpdate(student);
		
		//to add to logintable
		Integer maxSid=adminService.getMaxStudentId();
		LoginAuth loginAuth=new LoginAuth();
		loginAuth.setEmailId(student.getSemail());
		loginAuth.setPass(student.getSpassword());
		loginAuth.setStatus(0);
		loginAuth.setUserId(maxSid);
		loginAuth.setUtype("student");
		adminService.saveOrUpdate(loginAuth);
		//
	
		return new ModelAndView("redirect:/viewAllStudent");
	}
}
