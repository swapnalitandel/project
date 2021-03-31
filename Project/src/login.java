

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


@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	

		
		
		
		
		
		
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String uname= request.getParameter("search");
		String pname= request.getParameter("search1");
		try
		{
			Class.forName("oracle.jdbc.OracleDriver");
			Connection  conn=DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/orcl", "hr", "hr");
			 
			 PreparedStatement stmt=conn.prepareStatement("select * from doctor where (name like ? )");
			 stmt.setString(1,uname+"%");
			 stmt.setString(2,pname+"%");
			ResultSet rs=stmt.executeQuery();
			 while(rs.next())
			 {
				 response.sendRedirect(".html");
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
	}
	
	/*protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//String uname= request.getParameter("uname");
		//String pname= request.getParameter("pass");
		
		try
		{
			String uname= request.getParameter("uname");
			String pname= request.getParameter("pass");
		
			String username=null;
			String password=null;
			String sql="select * from doctor where name='"+uname+"' and email_id='"+pname+"'";
			Class.forName("oracle.jdbc.OracleDriver");
			Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/orcl", "hr", "hr");
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, uname);
			ps.setString(4, pname);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				
				username=rs.getString(1);
				password=rs.getString(4);
				
			}
			if(username.equals(uname) && password.equals(pname))
			{
				System.out.println("success");
			}
			else 
				{
					System.out.println("success");
				}
			
			
					
			
			
				
				
			
		}
		catch(Exception e)
		{
			System.out.println(" not inserted");
			System.out.println(e);
			e.printStackTrace();
		}
		
		
	}*/

}
