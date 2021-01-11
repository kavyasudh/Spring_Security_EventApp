package com.eventapp.beans;

public class TicketBookingRes {

	private String msg;
	private double amountPayable;


	public TicketBookingRes() {}

	public TicketBookingRes(String msg, double amountPayable) {
		
		this.msg = msg;
		this.amountPayable = amountPayable;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public double getAmountPayable() {
		return amountPayable;
	}
	public void setAmountPayable(double amountPayable) {
		this.amountPayable = amountPayable;
	}





}
