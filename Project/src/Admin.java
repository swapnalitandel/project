

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
@WebServlet("/Admin")
public class Admin extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public Admin() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		String s1=request.getParameter("s1");

		String s2=request.getParameter("s2");
		String s3=request.getParameter("s3");
		String s4=request.getParameter("s4");
		String s5=request.getParameter("s5");
		String s6=request.getParameter("s6");
		
	try
		{
			
			
			Class.forName("oracle.jdbc.OracleDriver");
			Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/orcl", "hr", "hr");
			Statement stmt=conn.createStatement();
			int executeUpdate=stmt.executeUpdate("insert into doctor5 values('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+s6+"')");
			
			
				out.println("Insredted");
			
				
				
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