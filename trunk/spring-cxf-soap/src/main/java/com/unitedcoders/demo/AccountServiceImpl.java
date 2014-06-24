package com.unitedcoders.demo;

import javax.jws.WebService;

@WebService(endpointInterface = "com.unitedcoders.demo.AccountService")
public class AccountServiceImpl implements AccountService {
	
	@Override
	public String account(String name) {
		Person person = new Person(name);
		return "Hello " + person.getName() + "!";
	}
}
