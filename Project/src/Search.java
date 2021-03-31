

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Search
 */
@WebServlet("/Search")
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname= request.getParameter("s1");
		String s2=request.getParameter("s2");
		
		int s4=Integer.parseInt(request.getParameter("s4"));
		int s5=Integer.parseInt(request.getParameter("s5"));
		String name = "Heart Disease";
		if(uname.equals("female") )
		{
			if(s2.equals("yes"))
			{
				
					if( (s4>120) || (s5>120))
					{
						 response.sendRedirect("d1.html");
						
	                }
					else if((s4<120) || (s5<120))
					{
						 response.sendRedirect("a1.html");
						 
					}
					else if((s4<120) || (s5<49))
					{
						 response.sendRedirect("a1.html");
					}
				
				
				
			}
		
	}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
