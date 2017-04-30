package One;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet1")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 response.setContentType("text/html");  
		    PrintWriter out = response.getWriter();  
		
		  
		   
		    String n=request.getParameter("userName");  
		    String p=request.getParameter("password");
		    String ph=request.getParameter("phno");
		          Check c = new Check();
		          
		    if(LoginDao.validate(n, p, ph)){  
		    	 
		        RequestDispatcher rd=request.getRequestDispatcher("servlet2");  
		        rd.forward(request,response);  
		    }  
		    else{  
		        out.print("Sorry username or password error");  
		        RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/views/loginView.jsp");  
		        rd.include(request,response);
		    }  
		          
		    out.close();  

	}

}
