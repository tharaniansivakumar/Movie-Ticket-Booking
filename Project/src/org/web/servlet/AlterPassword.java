package org.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.web.service.EmailService;
import org.web.service.LoginService;
import org.web.service.RandomService;

/**
 * Servlet implementation class AlterPassword
 */
@WebServlet("/alterpassword")
public class AlterPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlterPassword() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		try(PrintWriter out=response.getWriter() )
		{
			String emailId=request.getParameter("email");
			String key=RandomService.print();
			System.out.println(key);
			String subject="password change";
			String body="Enter this key";
			LoginService log=new LoginService();
			boolean res=log.valid(emailId);
			if(res==true)
			{
				EmailService.send(emailId,subject,body+key);
				response.sendRedirect("key.html");
			}
			else
			{
				out.println("User Not Found");
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
