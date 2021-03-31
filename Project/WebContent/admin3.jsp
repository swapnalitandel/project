<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.io.*,java.util.*,java.sql.*" %>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<html>
<head>
<link rel="stylesheet" href="admin.css" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style >
table,th,td
{
border:1px solid black;
border-collapse:collapse;
}
</style>
<title>Insert title here</title>
</head>
<body>
<div class="container">
<header>
<img src="login.jpg" height=50% width=100%%>
<h1>Health Disease Prediction</h1>
</header>
<ul>
<li><a class="active" href="admin.html"> Add Doctor  </a></li>
<li><a class="active" href="admin2.jsp">View User    </a></li>
<li><a class="active" href="admin.jsp">View Doctor   </a></li>
<li><a class="active" href="admin3.jsp"> View Feedback   </a></li>
<li><a class="active" href="LoginPage.html">Logout</a></li>
</ul>

<article>
<div class="simple-form">
<form  action="Admin" > 
<center><h1 color="black" >VIEW FEEDBACK </h1></center>


<center>
<table width="700"  bgcolor="#FFFFFF">
<tr >
<th>Feedback</th>

</tr>

<%
Connection conn=null;
Statement st=null;
ResultSet rs=null;

try
{
	
	
	Class.forName("oracle.jdbc.OracleDriver");
	 conn=DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/orcl", "hr", "hr");
	 st=conn.createStatement();
	 st=conn.createStatement();
	 String qry="select * from feedback";
	 rs=st.executeQuery(qry);
	 while(rs.next())
	 {
		 
		 %>
		<tr>
		<td><%= rs.getString(1) %></td>
		
		</tr>
		 <% 
	 }
	
	
	
}
catch(Exception e)
{
	System.out.println(" not inserted");
	System.out.println(e);
	e.printStackTrace();

}

%>
</table>
</center>
</form>
</div>
</article>
<footer>Disease Prediction</footer>
</div>
</body>
</html>