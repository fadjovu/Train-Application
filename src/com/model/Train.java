package com.model;

public class Train {

	private int TrainNo;
	private String TrainName;
	private String Source;
	private String Destination;
	private double TicketPrice;


	public Train() {
		// TODO Auto-generated constructor stub
	}

	public int getTrainNo() {
		return TrainNo;
	}

	public void setTrainNo(int trainNo) {
		TrainNo = trainNo;
	}

	public String getTrainName() {
		return TrainName;
	}

	public void setTrainName(String trainName) {
		TrainName = trainName;
	}

	public String getSource() {
		return Source;
	}

	public void setSource(String source) {
		Source = source;
	}

	public String getDestination() {
		return Destination;
	}

	public void setDestination(String destination) {
		Destination = destination;
	}

	public double getTicketPrice() {
		return TicketPrice;
	}

	public void setTicketPrice(double ticketPrice) {
		TicketPrice = ticketPrice;
	}
}
