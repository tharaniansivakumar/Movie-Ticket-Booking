package org.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.web.service.EmailService;
import org.web.service.LoginService;

/**
 * Servlet implementation class LogCustomer
 */
@WebServlet("/log")
public class LogCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogCustomer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			response.getWriter().append("Served at: ").append(request.getContextPath());
			try(PrintWriter out=response.getWriter())
			{
				String email=request.getParameter("uname");
				String code=request.getParameter("pswd");
				LoginService login=new LoginService();
				boolean res=login.validate(email,code);
				if(res==true)
				{
					out.println("Login Successfully");
					out.println("Logged with Access Key : " + code);
					out.println("Success :  ");
					Cookie cookie = new Cookie("auth_user",email);
					cookie.setMaxAge(24 * 60 * 60);
					response.addCookie(cookie);
					//EmailService emailService = new EmailService();
					//EmailService.send(email, "YOU HAVE LOGGED IN", "WELCOME TO THE CINEMAS");
					response.sendRedirect("view.html");
				}
				else
				{

					response.sendRedirect("Signup.html?val=1");
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
