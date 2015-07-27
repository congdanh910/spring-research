package com.demo.mongodb.controller;

import java.util.Date;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.mongodb.utils.Constant;
import com.mongodb.BasicDBObject;

@Controller
public class MongoDbTestController {
	@Autowired
	private MongoTemplate mongoTemplate;
	
	@RequestMapping("/index")
	public void index(HttpServletResponse response) throws Exception{
		Set<String> collections =  mongoTemplate.getCollectionNames();
		for (String col : collections) {
			response.getWriter().write("Name : " + col + "\n");
		}
		response.getWriter().write("Hello Mongodb!!!");
	}
	
	@RequestMapping("/add")
	public void add(HttpServletResponse response) throws Exception{
		BasicDBObject dbObject = new BasicDBObject();
		dbObject.put("name", "spring-trucxanh");
		dbObject.put("version", "1.0");
		dbObject.put("type", "spring-relaxing");
		dbObject.put("clients", 500);
		dbObject.put("createDate", new Date());
		
		mongoTemplate.insert(dbObject, Constant.MONGGO_COLLECTION_TEST);
	}
	

}
