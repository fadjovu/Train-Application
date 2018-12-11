<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import = "com.model.Passenger,com.model.Train,java.util.Map,com.model.Ticket,java.util.HashMap" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>request.setAttribute</title>
</head>
<body>
<!-- To display customer/s name age and gender and also display the total amount to be paid by the customer -->
<%
HttpSession session1 = request.getSession();
Ticket tic =(Ticket)session1.getAttribute("Ticket");
Train train=tic.getTrain();
/*HashMap<Passenger,Integer> map=tic.getPassengers(); 
for(Map.Entry<Passenger, Integer> entry : map.entrySet()) {
   Passenger pass=entry.getKey();
   int fare=entry.getValue();
   
}*/

%>
<!-- This page should display the name, age, gender and render the appropriate ticket price. -->
<!--  the request for payment from customer via credit card. -->
<h4>Ticket Details</h4>
<p>PNR: <%=tic.getPNR()%></p>
 <p>Train Number: <%=train.getTrainNo()%></p>
<p>Train Name: <%=train.getTrainName()%></p>
<p>Train From: <%=train.getSource()%>s</p>
<p>Train Destination: <%=train.getDestination()%></p>
<p>Train TravelDate: <%=tic.getTravelDate()%></p>

<h4>Passenger Details</h4>

<%
Double sum=0.0;
HashMap<Passenger,Double> map=tic.getPassengers(); 
for(Map.Entry<Passenger, Double> entry : map.entrySet()) {
	 Passenger pass=entry.getKey();
     Double fare=entry.getValue();
     sum=sum+fare;
   %>
   
   <p>Passenger Details</p>
   <p> Name <%=pass.getName() %> <br>
   		Age <%=pass.getAge() %> <br>
   		Gender <%=pass.getGender() %><br>
   		Fare <%=fare %>
   	</p>     
 <%   
}

tic.writeTicket();
%>
<p>Total fare: <%=sum %></p>

<a href="WEB-INF/jsp/Download.jsp">Download Ticket</a>

</body>
</html>