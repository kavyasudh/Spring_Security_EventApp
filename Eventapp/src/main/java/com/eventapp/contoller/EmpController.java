package com.eventapp.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eventapp.beans.TicketBooking;
import com.eventapp.service.EventService;

@RestController
@RequestMapping("emp")
public class EmpController {

	@Autowired
	private EventService eService;
	
	
	
	public EmpController(EventService eService) {
		
		this.eService = eService;
	}



	@PostMapping(path="bookTicket", 
			produces = MediaType.APPLICATION_JSON_VALUE, 
			consumes =MediaType.APPLICATION_JSON_VALUE )
	public String deposit( @RequestBody TicketBooking tBbean) {
		eService.bookTicket(tBbean.getEventId(),tBbean.getNoOfTickets());
		return "tickets booked successfully";
	}
}
