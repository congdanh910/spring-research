package com.demo.mongodb.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.demo.mongodb.model.Lead;
import com.demo.mongodb.repository.LeadsRepository;

@Controller
@RequestMapping("/leads")
public class LeadsController {

	@Autowired
	private LeadsRepository repository;
	
	@RequestMapping("/find/{firstname}")
	public void findByFirstname(@PathVariable("firstname") String firstname, HttpServletResponse response) throws IOException{
		System.out.println("Firstname :  " + firstname);
		List<Lead> lead = repository.findByFirstname(firstname);
		for (Lead l : lead) {
			response.getWriter().write(ToStringBuilder.reflectionToString(l) + "\n");
		}
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public void findByFirstname(HttpServletResponse response) throws IOException{
		Lead lead = new Lead();
		lead.setFirstname("Khanh");
		lead.setLastname("Dang");
		lead.setAge(27);
		lead.setBirthday(new Date());
		lead.setStatus(true);
		lead.setIncome(13.5);
		repository.save(lead);
		response.getWriter().write("Save lead successful!!!");
	}
}
