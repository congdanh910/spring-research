package com.demo.mongodb.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MongoDbController {
	@Autowired
	private MongoTemplate mongoTemplate;
	
	@RequestMapping("/index")
	public void index(HttpServletResponse response) throws Exception{
		Set<String> collections =  mongoTemplate.getCollectionNames();
		for (String col : collections) {
			response.getWriter().write("Name : " + col + "<br />");
		}
		response.getWriter().write("Hello Mongodb!!!");
	}
	
	@RequestMapping("/add")
	public void add(HttpServletResponse response) throws Exception{
		Map<String, Object> data = new HashMap<>();
		data.put("name", "spring-trucxanh");
		data.put("version", "1.0");
		data.put("type", "spring-relaxing");
		data.put("clients", 500);
		data.put("createDate", new Date());
		
		mongoTemplate.insert(data);
	}
	

}
