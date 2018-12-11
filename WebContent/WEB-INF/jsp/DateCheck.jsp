<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.model.Train" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% Train tr= (Train)request.getAttribute("gtrain"); %>


<h1>Displaying Train Information:</h1> 
      <table border ="1" width="500">
         <tr bgcolor="00FF7F"> 
          <th><b>TrainNo</b></th> 
          <th><b>Train Name</b></th> 
          <th><b>Source</b></th> 
           <th><b>Destination</b></th>
         </tr> 
         <tr>
         <td><%=tr.getTrainNo() %></td>
         <td><%=tr.getTrainName()%></td>
         <td><%=tr.getSource() %></td>
         <td><%=tr.getDestination() %></td>
         
         
         </tr>
         </table><br>

<form action="CheckDateServlet" method="Get">
Enter Travel Date:
<input type="date" name="tdate" required="required"><br>
Enter Number of Passengers:
<input type="number" name="pcount" required="required"><br>
<input type="submit" value="Next" >
</body>
</html>