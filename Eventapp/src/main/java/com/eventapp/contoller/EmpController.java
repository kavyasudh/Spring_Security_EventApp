package com.eventapp.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eventapp.beans.TicketBookingReq;
import com.eventapp.beans.TicketBookingRes;
import com.eventapp.beans.TicketCancelReq;
import com.eventapp.beans.TicketCancelRes;
import com.eventapp.service.EventService;

@RestController
@RequestMapping("emp")
public class EmpController {

	@Autowired
	private EventService eService;
	
	
	
	public EmpController(EventService eService) {
		
		this.eService = eService;
	}


	/*
	 * @PostMapping(path="bookTicket", produces = MediaType.APPLICATION_JSON_VALUE,
	 * consumes =MediaType.APPLICATION_JSON_VALUE ) public String book( @RequestBody
	 * TicketBookingReq tBbean) {
	 * eService.bookTicket(tBbean.getEventId(),tBbean.getNoOfTickets()); return
	 * "tickets booked successfully"; }
	 */
	
	

	@PostMapping(path="booking", 
			produces = MediaType.APPLICATION_JSON_VALUE, 
			consumes =MediaType.APPLICATION_JSON_VALUE )
	public TicketBookingRes booking( @RequestBody TicketBookingReq bookreq) {
		
		return eService.bookTickets(bookreq);
	}
	
	@PostMapping(path="cancel", 
			produces = MediaType.APPLICATION_JSON_VALUE, 
			consumes =MediaType.APPLICATION_JSON_VALUE )
	public TicketCancelRes cancel( @RequestBody TicketCancelReq cancelreq) {
		
		return eService.cancelTickets(cancelreq);
	}
}
