package com.model;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;

public class Ticket {
	private static int counter;
	private String PNR;
	private LocalDate travelDate;
	private Train train;
	private HashMap<Passenger, Double> passengers = new HashMap<>();
	
	public Ticket(LocalDate travelDate, Train train) {
		this.travelDate = travelDate;
		this.train = train;
		
	}

	public Ticket() {
	}


	public void addPassenger(String name, int age, char gender) {
		// 1. given name, age, gender, create the p object
		Passenger pobj = new Passenger(name, age, gender);
		
		// 2. call the method calcPassengerFare() to calculate fare for this pobj
		double fare = calcPassengerFare(pobj);
		
		// 3. add <p, f> to passengers, which is the treeMap
		passengers.put(pobj, fare);
		
	}
	
	public double calcPassengerFare(Passenger p) {
		
		double ticket_fare = train.getTicketPrice();
		
		
		System.out.println("Before"+ticket_fare);
		if(p.gender == 'f'||p.gender =='F') {
			ticket_fare = train.getTicketPrice() * 0.75;
		}
		if(p.age <= 12) {
			ticket_fare = train.getTicketPrice() * 0.5;
		}
		if(p.age >= 60) {
			ticket_fare = train.getTicketPrice() * 0.6;
		}
		System.out.println("After"+ticket_fare);
		return ticket_fare;
	}
	
	public Double calcTotalTicketPrice() {		
		Double sum = 0.0;
		for (Double f : passengers.values()) {
		    sum = sum + f;
		}
	
		return sum;
	}
	
	public StringBuilder generateTicket() {
		
	
		StringBuilder bud = new StringBuilder();
		
		bud.append("Ticket");
		bud.append(System.getProperty("line.separator"));
		bud.append("PNR       : ");
		bud.append(generatePNR());
		bud.append(System.getProperty("line.separator"));
		bud.append("TRAIN NO  : ");
		bud.append(train.getTrainNo());
		bud.append(System.getProperty("line.separator"));
		bud.append("TRAIN NAME: ");
		bud.append(train.getTrainName());
		bud.append(System.getProperty("line.separator"));
		bud.append("FROM      : ");
		bud.append(train.getSource());
		bud.append(System.getProperty("line.separator"));
		bud.append("TO        : ");
		bud.append(train.getDestination());
		bud.append(System.getProperty("line.separator"));
		bud.append("TRAVEL DATE: ");
		bud.append(travelDate);
		bud.append(System.getProperty("line.separator"));
		bud.append(System.getProperty("line.separator"));
		bud.append("Name   Age    Gender   Fare");
		System.out.println(passengers.keySet());
		
		for(Passenger p: passengers.keySet()) {
//			bud.append("Name   Age    Gender   Fare");
			bud.append(System.getProperty("line.separator"));
			bud.append(p.name +"       " +p.age + "         "+ p.gender + "         " + passengers.get(p));

		}
//		passengers.get(key)
		bud.append(System.getProperty("line.separator"));
		bud.append("Total fare:   " + calcTotalTicketPrice());
	
	
		return bud;
		
		// format the content of ticket 
	}
	
	// write ticket method
	public void writeTicket() {
		               
		File trticket = new File("C:\\TrainTicket\\Ticket" + counter +".txt");
		if(!trticket.exists()) {
			try {
				trticket.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		FileOutputStream gen;
		try {
			gen = new FileOutputStream(trticket);
			gen.write(generateTicket().toString().getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	private String generatePNR() {
		
        StringBuilder sb = new StringBuilder();
	    Arrays.asList(train.getSource().split(" ")).forEach(s -> sb.append(s.charAt(0)).append(""));
	    Arrays.asList(train.getDestination().split(" ")).forEach(s -> sb.append(s.charAt(0)).append(""));
	    sb.append("_" + travelDate.getYear() + travelDate.getMonthValue() +travelDate.getDayOfMonth());
	    sb.append("_" + counter);
    
    this.PNR=sb.toString().trim();
    return sb.toString().trim();

	}
	
	
	public static int getCounter() {
		return counter;
	}

	public static void setCounter(int counter) {
		Ticket.counter = counter;
	}

	public String getPNR() {
		return PNR;
	}

	public void setPNR(String pNR) {
		PNR = pNR;
	}

	public LocalDate getTravelDate() {
		return travelDate;
	}

	public void setTravelDate(LocalDate travelDate) {
		this.travelDate = travelDate;
	}

	public Train getTrain() {
		return train;
	}

	public void setTrain(Train train) {
		this.train = train;
	}

	public HashMap<Passenger, Double> getPassengers() {
		return passengers;
	}

	public void setPassengers(HashMap<Passenger, Double> passengers) {
		this.passengers = passengers;
	}


}
