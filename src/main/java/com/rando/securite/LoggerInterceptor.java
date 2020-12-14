package com.rando.securite;

import java.net.URLDecoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.rando.modele.User;

public class LoggerInterceptor extends HandlerInterceptorAdapter{
	

	private static org.slf4j.Logger log = LoggerFactory.getLogger(LoggerInterceptor.class);

	@Override
	public boolean preHandle(
	  HttpServletRequest request,
	  HttpServletResponse response, 
	  Object handler) throws Exception {
		
	    User checkUser = (User) request.getSession().getAttribute("userok");
	    System.out.println(checkUser);
		if(checkUser == null && !request.getRequestURI().endsWith("/login") && request.getRequestURI().indexOf("admin") != -1) {
			System.out.println("pas bien");
			response.sendRedirect(request.getContextPath() + "/admin/login");
			return false;
		}
	    System.out.println("bien");
	    return true;
	}
	
	@Override
	public void postHandle(
	  HttpServletRequest request, 
	  HttpServletResponse response,
	  Object handler, 
	  ModelAndView modelAndView) throws Exception {
	    
	    log.info("[postHandle][" + request + "]");
	}
	
	@Override
	public void afterCompletion(
	  HttpServletRequest request, HttpServletResponse response,Object handler, Exception ex) 
	  throws Exception {
	    if (ex != null){
	        ex.printStackTrace();
	    }
	    log.info("[afterCompletion][" + request + "][exception: " + ex + "]");
	}
	
	
}
