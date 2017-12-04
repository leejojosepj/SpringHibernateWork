package com.leejo.bo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.WebUtils;
/**
 * 
 * @author Leejo Jose
 * @date 01-11-2017
 *
 */
public class Interceptor extends HandlerInterceptorAdapter{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		
		
		if(WebUtils.getSessionAttribute(request,"loggedInUser")==null){
			String requestUrl = request.getRequestURI().substring(request.getContextPath().length());
			System.out.println("not login");
			if(!requestUrl.equals("/")&&!requestUrl.equals("/loginCheck")&&!requestUrl.equals("/interceptorExample"))
				throw new ModelAndViewDefiningException(new ModelAndView("redirect:/"));

		}
		
		
		
		
		
		
		return true;
		
		
		
		
		
	}

}
