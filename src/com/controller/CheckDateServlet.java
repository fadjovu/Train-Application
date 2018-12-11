package com.controller;


import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.Ticket;

/**
 * Servlet implementation class CheckDate
 */
@WebServlet("/CheckDateServlet")
public class CheckDateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckDateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	String pcount = request.getParameter("pcount");
		LocalDate date1 = LocalDate.parse(request.getParameter("tdate"));
		
		LocalDate today = LocalDate.now();
		
	if(date1.isBefore(today)) {
		response.getWriter().append("Invalid Date ");
		response.sendRedirect("/WEB-INF/jsp/DateCheck.jsp");
	}
	else {
		HttpSession session=request.getSession();
		Ticket ticket=(Ticket) session.getAttribute("Ticket");
		ticket.setTravelDate(date1);
		
		session.setAttribute("Ticket", ticket);
		request.setAttribute("pcount", pcount);
		request.getRequestDispatcher("/WEB-INF/jsp/Reservation.jsp").forward(request, response);
	}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
