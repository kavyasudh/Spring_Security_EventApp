package com.eventapp.dao;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "event_table")
public class Event {
	
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int eventId;
	
	@Column(name="ename") 
	private String eventName;
	@Column(name="eloc") 
	private String location;
	
	@Temporal(TemporalType.DATE)
	@Column(name="edate") 
	private Date eventDate;
	@Column(name="ediscount") 
	private int discount;
	@Column(name="No_Of_tickets") 
	private int noOfTickets;
	
	private double price;
	
	
	public Event() {}
	public Event(String eventName, String location, Date eventDate, int discount, int noOfTickets,double price) {

		this.eventName = eventName;
		this.location = location;
		this.eventDate = eventDate;
		this.discount = discount;
		this.noOfTickets = noOfTickets;
	    this.price=price;
	}
	public int getEventId() {
		return eventId;
	}
	public void setEventId(int eventId) {
		this.eventId = eventId;
	}
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Date getEventDate() {
		return eventDate;
	}
	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public int getNoOfTickets() {
		return noOfTickets;
	}
	public void setNoOfTickets(int noOfTickets) {
		this.noOfTickets = noOfTickets;
	}
	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Event [eventId=" + eventId + ", eventName=" + eventName + ", location=" + location + ", eventDate="
				+ eventDate + ", discount=" + discount + ", noOfTickets=" + noOfTickets + ", price=" + price + "]";
	}
	
	

}
