package com.controller;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.Passenger;
import com.model.Ticket;

/**
 * Servlet implementation class ReservationServlet
 */
@WebServlet("/ReservationServlet")
public class ReservationServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Number of passengers
		String count=request.getParameter("count");
		int cont=Integer.parseInt(count);
		
		Passenger p=null;
		HttpSession session = request.getSession();
		Ticket ticket = (Ticket) session.getAttribute("Ticket");
		
		for(int i=0;i<cont;i++) {
			p=new Passenger();
			p.setName(request.getParameter("flname" + i));
			p.setGender(request.getParameter("gender" + i).charAt(0));
			p.setAge(Integer.parseInt(request.getParameter("age" + i)));
			ticket.addPassenger(p.getName(), p.getAge(), p.getGender());
		}
		ticket.generateTicket();
		System.out.println(ticket.getPNR());
		session.setAttribute("Ticket",ticket);
		request.getRequestDispatcher("/WEB-INF/jsp/Ticket.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
