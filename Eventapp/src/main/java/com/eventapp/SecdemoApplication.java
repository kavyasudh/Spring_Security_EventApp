package com.eventapp;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.eventapp.dao.Event;
import com.eventapp.dao.User;
import com.eventapp.service.EventService;
import com.eventapp.service.UserService;

@SpringBootApplication
public class SecdemoApplication implements CommandLineRunner {

	@Autowired
	private UserService userService;

	@Autowired
	private EventService eventService;

	public static void main(String[] args) {
		SpringApplication.run(SecdemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		
		/*
		 * User user1=new User("kavya", "kavya", new String[]{"ROLE_MGR","ROLE_EMP"});
		 * User user2=new User("sudha", "sudha", new String[] {"ROLE_EMP"}); User
		 * user3=new User("sathish", "sathish", new String[]{"ROLE_EMP"});
		 * 
		 * userService.addUser(user1); userService.addUser(user2);
		 * userService.addUser(user3); System.out.println("added users--------------");
		 * 
		 */
		  
		  
		/*
		 * SimpleDateFormat fmt=new SimpleDateFormat("dd/MM/yyyy"); Date
		 * d1=fmt.parse("14/02/2021"); Date d2=fmt.parse("26/02/2021"); Date
		 * d3=fmt.parse("3/02/2021");
		 * 
		 * 
		 * Event e1=new Event("Singing", "Hyderabad", d1, 10, 20,250); Event e2=new
		 * Event("Dancing", "vskp", d2, 8, 10,350); Event e3=new
		 * Event("Drawing","vzm",d3, 11, 15,200);
		 * 
		 * eventService.addEvent(e1); eventService.addEvent(e2);
		 * eventService.addEvent(e3);
		 * 
		 * System.out.println("added events--------------");
		 */
		
		
		/*
		 * SimpleDateFormat fmt=new SimpleDateFormat("dd/MM/yyyy"); Date
		 * d1=fmt.parse("1/01/2021"); Event e1=new Event("rangoli", "sklm", d1, 10,
		 * 20,150); eventService.addEvent(e1); System.out.println("new event added");
		 */
		
	}

}
