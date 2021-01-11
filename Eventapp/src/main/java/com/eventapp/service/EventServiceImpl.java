package com.eventapp.service;

import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eventapp.beans.TicketBookingReq;
import com.eventapp.beans.TicketBookingRes;
import com.eventapp.beans.TicketCancelReq;
import com.eventapp.beans.TicketCancelRes;
import com.eventapp.dao.*;

import com.eventapp.exceptions.EventNotFound;
import com.eventapp.repo.EventRepo;
@Service
@Transactional
public class EventServiceImpl implements EventService{

	@Autowired
	private EventRepo eventRepo;
	
	
	public EventServiceImpl(EventRepo eventRepo) {
		this.eventRepo = eventRepo;
	}

	@Override
	public List<Event> getAllEvents() {
		return eventRepo.findAll();
	}

	@Override
	public void addEvent(Event event) {
		eventRepo.save(event);
		
	}

	@Override
	public Event updateEventDetails(int eventId, Event event) {
		Event eventUpdate=getEventById(eventId);
		eventUpdate.setEventDate(event.getEventDate());
		eventUpdate.setLocation(event.getLocation());
		eventUpdate.setEventName(event.getEventName());
		eventUpdate.setDiscount(event.getDiscount());
		eventUpdate.setNoOfTickets(event.getNoOfTickets());
		eventRepo.save(eventUpdate);
		return eventUpdate;
	}

	@Override
	public Event deleteEventDetails(int eventId) {
		Event eventDelete=getEventById(eventId);
		eventRepo.delete(eventDelete);
		return eventDelete;
	}

	@Override
	public Event getEventById(int eventId) {
		Event eventById=eventRepo.findById(eventId).orElseThrow(()->new EventNotFound("Event Details are not there"));
		return eventById;
	}

	@Override
	public Event findByName(String eventName) {
		return eventRepo.findByEventName(eventName);
	}

	/*
	 * @Override public void bookTicket(int eventId, int noOfTickets) { // TODO
	 * Auto-generated method stub Event tickets=getEventById(eventId);
	 * tickets.setNoOfTickets(tickets.getNoOfTickets()-noOfTickets);
	 * eventRepo.save(tickets);
	 * 
	 * }
	 */

	@Override
	public TicketBookingRes bookTickets(TicketBookingReq req) {
		// TODO Auto-generated method stub
		TicketBookingRes res=new TicketBookingRes();
		Event bookTicket=getEventById(req.getEventId());
		
       if(bookTicket==null)
			
			throw new EventNotFound("Event Details with:"+req.getEventId()+"are not there");
      
  
		
		if(req.getNoOfTickets()>bookTicket.getNoOfTickets())
		{
			res.setMsg("no. of tickets requested is more than available tickets");
			res.setAmountPayable(0.0);
		}
		  if((bookTicket.getEventDate()).before(new Date()))
			{
				res.setMsg("event is already expired.Plz book ticket for Existing events");
				res.setAmountPayable(0.0);
			}
		else
		{
			
			bookTicket.setNoOfTickets(bookTicket.getNoOfTickets()-req.getNoOfTickets());
			this.updateEventDetails(bookTicket.getEventId(), bookTicket);
			res.setMsg("tickets booked successfully");
			double amount=(bookTicket.getPrice()*req.getNoOfTickets())*(100-bookTicket.getDiscount())/100;
					
			res.setAmountPayable(amount);
			
		}
		
		
		return res;
	}

	@Override
	public TicketCancelRes cancelTickets(TicketCancelReq req) {
		// TODO Auto-generated method stub
		TicketCancelRes res=new TicketCancelRes();
		Event cancelTicket=getEventById(req.getEventId());
		
		if(cancelTicket==null)
			
			throw new EventNotFound("Event Details with:"+req.getEventId()+"are not there");
		if((cancelTicket.getEventDate()).before(new Date()))
		{
			res.setMsg("event is already expired, we cannot refund");
			res.setAmountRefunded(0.0);
		}
		else
		{
			
			cancelTicket.setNoOfTickets(cancelTicket.getNoOfTickets()+req.getNoOfTickets());
			this.updateEventDetails(cancelTicket.getEventId(), cancelTicket);
			res.setMsg("tickets cancelled successfully");
			double amount=(cancelTicket.getPrice()*req.getNoOfTickets())*(100-cancelTicket.getDiscount())/100;
					
			res.setAmountRefunded(amount*0.5);
			
		}
		return res;
	}

}
