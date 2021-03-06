package com.eventapp.contoller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@GetMapping(path="home")
	public String home(){
		return "hello to home";
	}
	
	@GetMapping(path="admin")
	public String homeAdmin(){
		return "hello to admin";
	}
	
	@GetMapping(path="mgr")
	public String homeMgr(){
		return "hello to mgr";
	}
	
	@GetMapping(path="emp")
	public String homeEmp(){
		return "hello to emp";
	}
}
