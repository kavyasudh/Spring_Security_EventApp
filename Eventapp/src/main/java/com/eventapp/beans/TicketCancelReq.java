package com.eventapp.beans;

public class TicketCancelReq {

	private int eventId;

	private int noOfTickets;

	public TicketCancelReq(int eventId, int noOfTickets) {
		
		this.eventId = eventId;
		this.noOfTickets = noOfTickets;
	}

	public TicketCancelReq() {}

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
