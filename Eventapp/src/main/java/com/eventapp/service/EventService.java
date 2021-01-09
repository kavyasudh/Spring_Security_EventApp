package com.eventapp.service;
import java.util.List;

import com.eventapp.dao.Event;
public interface EventService {

	
	public List<Event> getAllEvents();
	public void addEvent(Event event);
	public Event updateEventDetails(int eventId,Event event);
	public Event deleteEventDetails(int eventId);
	public Event getEventById(int eventId);
	public Event findByName(String name);
    public void bookTicket(int eventId,int noOfTickets);

}
