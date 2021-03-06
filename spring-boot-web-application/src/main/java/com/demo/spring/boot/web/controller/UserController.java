package com.demo.spring.boot.web.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.demo.spring.boot.web.form.UserForm;
import com.demo.spring.boot.web.model.User;
import com.demo.spring.boot.web.redis.UserToCache;
import com.demo.spring.boot.web.services.UserService;
import com.demo.spring.boot.web.uuid.UniqueId;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private RedisTemplate<String, String> redisTemplate;

	@Autowired
	@Qualifier("uuid")
	private UniqueId uuid;

	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping("/list")
	public String list(Model model) {
		List<User> users = userService.listAll();
		model.addAttribute("users", users);
		return "user/list";
	}

	@PreAuthorize("@userServiceImpl.canAccessUser(principal, #id)")
	@RequestMapping("/{id}")
	public String userDetail(@PathVariable String id, Model model) {
		User user = userService.findById(id);
		model.addAttribute("user", user);
		return "user/user";
	}

	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String create() {
		return "user/create";
	}

	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/createUser", method = RequestMethod.POST)
	public String createUser(@ModelAttribute("user") UserForm userForm, Model model) {
		try {
			if (userForm != null) {
				User user = new User(uuid.getStringId(), userForm);
				userService.saveOrUpdate(user);
			} else {
				model.addAttribute("error", "You are missing something, please recheck the information in the form!");
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			model.addAttribute("exception",
					"We have a exception when creating the User, please try again or contact the admin page!");
			return "user/create";
		}
		return "redirect:/user/list";
	}

	@PreAuthorize("@userServiceImpl.canAccessUser(principal, #id)")
	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public String update(@PathVariable String id, Model model) {
		if (StringUtils.isNotBlank(id)) {
			model.addAttribute("user", userService.findById(id));
		}
		return "user/update";
	}

	@PreAuthorize("@userServiceImpl.canAccessUser(principal, #id)")
	@RequestMapping(value = "/updateUser", method = RequestMethod.POST)
	public String updateUser(@ModelAttribute("user") UserForm userForm, Model model) {
		try {
			if (userForm != null) {
				User user = new User(userForm.getId(), userForm);
				System.out.println("updateUser : " + ToStringBuilder.reflectionToString(user));
				redisTemplate.executePipelined(new UserToCache(user));
			} else {
				model.addAttribute("error", "You are missing something, please recheck the information in the form!");
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			model.addAttribute("exception",
					"We have a exception when updating the User, please try again or contact the admin page!");
			return "user/update";
		}
		return "redirect:/user/list";
	}

}
