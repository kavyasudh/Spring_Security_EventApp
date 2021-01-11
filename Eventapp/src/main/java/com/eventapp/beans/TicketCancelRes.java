package com.eventapp.beans;

public class TicketCancelRes {

	private String msg;
	private double amountRefunded;


	public TicketCancelRes() {}

	public TicketCancelRes(String msg, double amountRefunded) {
		
		this.msg = msg;
		this.amountRefunded = amountRefunded;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}

	public double getAmountRefunded() {
		return amountRefunded;
	}

	public void setAmountRefunded(double amountRefunded) {
		this.amountRefunded = amountRefunded;
	}
	




}
