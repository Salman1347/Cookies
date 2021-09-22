package Sessions;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/login")
public class loginServlet extends HttpServlet {
	
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		response.sendRedirect("login.html");
		
	}
		
		
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String useremail = request.getParameter("email");
		String password = request.getParameter("password");
		
		if(useremail !=null && !useremail.equals("") && !password.equals("")) {
			if(useremail.equals("syed") && password.equals("salman")) {
				// login success then create cookie
				//create cookie
				Cookie ck = new Cookie("useremail", useremail);
				// add cookie in response
				response.addCookie(ck);
				out.println("Login sucessfull"  + useremail);
			} else {
				out.println(" Invalid credntials");
			}
		} else {
			out.println("Login Failed  * Required filled are missing! ");
		}
		
}
}
