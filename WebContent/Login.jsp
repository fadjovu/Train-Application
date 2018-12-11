<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
if(request.getAttribute("Reg")!=null){
	if(request.getAttribute("Reg").equals("Success")){
	out.print("Registered Successfully");
}
	}
%>
<!-- Form for validiating Login Credntails -->
<form action="LoginServlet" method="Get">
		Enter your Username:
		<input type="text" name="uname"><br>
		Enter your Password:
		<input type="text" name="pword"><br>
		<input type="submit" value="Login"><br>
</form>

<!--  Redirect to another page to register new user  -->
Register:
<a href="Registration.jsp">Register Here</a>
</body>
</html>