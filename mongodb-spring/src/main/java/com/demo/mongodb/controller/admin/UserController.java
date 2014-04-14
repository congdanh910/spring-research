package com.demo.mongodb.controller.admin;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.mongodb.domain.Role;
import com.demo.mongodb.domain.User;
import com.demo.mongodb.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController{

	@Autowired
	private UserService userService;

	@RequestMapping("/list")
	public String list(Model model) throws Exception{
		List<User> users = userService.findAll();
		model.addAttribute("users", users);
		return "list";
	}
	@RequestMapping("/save")
	public void save(HttpServletResponse response) throws Exception{
		User user = new User();
		user.setFirstName("Ho");
		user.setLastName("Danh");
		user.setUsername("congdanh");
		user.setBirthday(new Date());
		user.setActive(true);
		Role role = new Role();
		role.setRole("admin");
		user.setRole(role);
		userService.create(user);
		response.getWriter().write("OK");
	}
	
	
}
