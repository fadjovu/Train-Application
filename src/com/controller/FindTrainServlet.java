package com.controller;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.trainDao;
import com.model.Ticket;
import com.model.Train;

@WebServlet("/FindTrainServlet")
public class FindTrainServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ftrain = request.getParameter("ftrain");
		
		try {
			
			trainDao train=new trainDao();
			Train trn=train.getTrain(Integer.parseInt(ftrain));
			if(trn !=null) {
				Ticket ticket=new Ticket();
				ticket.setTrain(trn);
				// Storing the ticket in session 
				HttpSession session=request.getSession();
				session.setAttribute("Ticket", ticket);
				
				request.setAttribute("gtrain", trn);
				request.getRequestDispatcher("/WEB-INF/jsp/DateCheck.jsp").forward(request, response);
			}
			
		}catch (Exception e) {
			
//			request.getRequestDispatcher("DateCheck.jsp").forward(request, response);
		}

//		response.getWriter().append("Served at: "+ trn.getTrainNo()+trn.getTrainName()+trn.getSource()+trn.getDestination() );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
