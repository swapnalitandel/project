

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Fd")
public class Fd extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		String s1=request.getParameter("s1");

		
		
	try
		{
			
			
			Class.forName("oracle.jdbc.OracleDriver");
			Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/orcl", "hr", "hr");
			Statement stmt=conn.createStatement();
			int executeUpdate=stmt.executeUpdate("insert into feedback values('"+s1+"')");
			
			
				out.println("Inserted");
			
				
				
			conn.close();
		}
		catch(Exception e)
		{
			System.out.println(" not inserted");
			System.out.println(e);
			e.printStackTrace();
		}
		
	}
		
	}

	
	

