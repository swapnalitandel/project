

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Feedback
 */
@WebServlet("/Feedback")
public class Feedback extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String getFirstName = request.getParameter("search");
		String getFirstName1 = request.getParameter("search1");
		String getFirstName2 = request.getParameter("search");
		try
		{
			Class.forName("oracle.jdbc.OracleDriver");
			Connection  conn=DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/orcl", "hr", "hr");
			 
			// 
			//PreparedStatement stmt=conn.prepareStatement("select name,address from doctor where (name like ?) and (address like ?)");
			
			PreparedStatement stmt=conn.prepareStatement("select * from doctor where name = '"+getFirstName+"' and adress='"+getFirstName1+"'");
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
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
