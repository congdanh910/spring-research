package com.demo.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.model.EmailObject;
import com.demo.utils.CapturesServletResponse;
import com.demo.utils.PathUtils;
import com.demo.utils.TemplateMatcher;

@Controller
public class HomeController {
	@Autowired
	private PathUtils pathUtils;
	
	@RequestMapping("/home")
	public String home(HttpServletRequest request, HttpServletResponse response) {
		try {
			RequestDispatcher rd = request.getRequestDispatcher(pathUtils.getTemplatePath()+"hello.html");
			CapturesServletResponse servletResponse = new CapturesServletResponse(response);
			rd.include(request, servletResponse);
			String mailBody = servletResponse.getResponseAsString();
			TemplateMatcher matcher = new TemplateMatcher("${\"", "\"}");
			EmailObject emailObject = new EmailObject("Danh", "Ho", 26, "Tien Giang", "0947579583", "congdanh910@gmail.com");
			response.getWriter().write(matcher.replace(mailBody, emailObject.mapper()));
		} catch (Exception exception) {

		}
		return null;
	}
}
