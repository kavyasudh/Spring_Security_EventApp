package com.eventapp.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

	@Override
	public void bookTicket(int eventId, int noOfTickets) {
		// TODO Auto-generated method stub
		Event tickets=getEventById(eventId);
		tickets.setNoOfTickets(tickets.getNoOfTickets()+noOfTickets);
		eventRepo.save(tickets);
		
	}

}
