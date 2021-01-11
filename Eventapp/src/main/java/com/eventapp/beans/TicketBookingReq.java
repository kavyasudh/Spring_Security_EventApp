package com.eventapp.beans;

public class TicketBookingReq {

private int eventId;

private int noOfTickets;

public TicketBookingReq(int eventId, int noOfTickets) {
	
	this.eventId = eventId;
	this.noOfTickets = noOfTickets;
}

public TicketBookingReq() {}

public int getEventId() {
	return eventId;
}

public void setEventId(int eventId) {
	this.eventId = eventId;
}

public int getNoOfTickets() {
	return noOfTickets;
}

public void setNoOfTickets(int noOfTickets) {
	this.noOfTickets = noOfTickets;
}



}
