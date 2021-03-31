<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.io.*,java.util.*,java.sql.*" %>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<html>
<head>
<link rel="stylesheet" href="login.css" type="text/css">
</head>
<body>
<div class="container">
<header>
<img src="login.jpg" height=50% width=100%%>
<h1>Health Prediction</h1>
</header>
<ul>
<li><a class="active" href="mydetails.html">My Details</a></li>
<li><a class="active" href="SD.html">Search Disease</a></li>
<li><a class="active" href="SDo.html">Search Doctor</a></li>
<li><a class="active" href="Feedback.html">Feedback</a></li>
</ul>


<article>
<div class="simple-form">
<form  method="post" action="SDo.jsp"> 
<h1> </h1>
<input type="text" name="search" id="button" placeholder="Location"><br><br>
<input type="text" name="s2" id="button" placeholder="Are you Smoked"><br><br>
<input type="submit" value="Login" id="butt"><br><br>


</form>
<%
String getFirstName = request.getParameter("search");
try
{
	Class.forName("oracle.jdbc.OracleDriver");
	Connection  conn=DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/orcl", "hr", "hr");
	 
	 PreparedStatement stmt=conn.prepareStatement("select * from doctor where (name like ?)");
	 stmt.setString(1,getFirstName+"%");
	ResultSet rs=stmt.executeQuery();
	 while(rs.next())
	 {
		out.println( rs.getString(1)+""+ rs.getString(2)+""+ rs.getString(3)+""+ rs.getString(4)+""+ rs.getString(5));
		out.println("<br/>");
		
		 
	 }
}
catch(Exception e)
{
	System.out.println(" not inserted");
	System.out.println(e);
	e.printStackTrace();

}
%>
</article>
<footer>Disease Predivtion</footer>
</div>
</body>
</html>