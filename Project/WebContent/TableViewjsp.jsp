<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.sql.*"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.io.*,java.util.*,java.sql.*" %>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
<table border="1">
<tr >
<td>Name</td>
<td>Address</td>
<td>Mobile</td>
<td>Email_id</td>
<td>Gender</td>
</tr>
<tr>
<input type="text" name="s1" id="button" placeholder="Gender"><br><br>
<input type="text" name="s2" id="button" placeholder="Are you Smoked"><br><br>
<input type="text" name="s3" id="button" placeholder="Age"><br><br>
<input type="text" name="s4" id="button" placeholder="Resting Blood Pressure"><br><br>
<input type="text" name="s5" id="button" placeholder="Cholestoral"><br><br>
<input type="text" name="s6" id="button" placeholder="Blood SUgar"><br><br>
<input type="text" name="s7" id="button" placeholder="Resting Electrocardiographic"><br><br>
<input type="text" name="s8" id="button" placeholder="Weight"><br><br>
</tr>

<%

	

response.setContentType("text/html");
//PrintWriter out = response.getWriter();

String getFirstName = request.getParameter("s1");
String getFirstName1 = request.getParameter("s2");
String getFirstName2 = request.getParameter("s3");
try
{
	Class.forName("oracle.jdbc.OracleDriver");
	Connection  conn=DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/orcl", "hr", "hr");
	 
	// 
	//PreparedStatement stmt=conn.prepareStatement("select * from doctor where (name like ? and address like?)");
	
	PreparedStatement stmt=conn.prepareStatement("select * from doctor where name = "+getFirstName+"");
	 stmt.setString(1,getFirstName+"%");
	 stmt.setString(2,getFirstName1+"%");
	ResultSet rs=stmt.executeQuery();
	 while(rs.next())
	 {
		 
		out.print( rs.getString(1));
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
</table>
</center>

</body>
</html>