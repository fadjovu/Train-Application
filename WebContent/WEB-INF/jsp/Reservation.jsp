<!DOCTYPE html>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%String count1 = request.getParameter("pcount");
int cont=Integer.parseInt(count1);
%>
<form action="ReservationServlet" method="Get">
	<h3>Please Enter your Information Below </h3>
	<% for(int i=0; i<cont; i++) { %>
			Enter your Name:
			<input type="text" name="flname<%=i%>" ><br>
			Enter your Age:
			<input type="number" name= "age<%=i%>"><br>
			Enter your Gender:
			<input type="text" name="gender<%=i%>"><br>
	<% }%>
	<input type=hidden name="count" value=<%=cont %>>
	<input type="submit" value="Purchase Ticket" name="ticket">
</form>
<%int val=2; %>


	
</body>
</html>