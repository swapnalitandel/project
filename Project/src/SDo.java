

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/SDo")
public class SDo extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public SDo() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		
		
		
		String uname= request.getParameter("s1");
		
		if(uname.equals("Santacruz") )
		{
			request.getRequestDispatcher("SDo.html").include(request, response);
			
		}
		else if(uname.equals("Malad"))
				{
			out.print("Sorry,username or password error!");
			request.getRequestDispatcher("SDo.html").include(request, response);
			
		
		}
		else if(uname.equals("Vasai"))
		{
	

        }
		else if(uname.equals("Dadar"))
		{
	

        }
		else if(uname.equals("Khar"))
		{
	

        }
		else if(uname.equals("Bandra"))
		{
	

        }
		else if(uname.equals("Mahim"))
		{
	

        }
		else if(uname.equals("Andheri"))
		{
	

        }
		else 
		{
	

        }
	}

}
