package org.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.web.modal.util.CKUtil;
import org.web.service.ScreenService;
import org.web.service.Showservice;

/**
 * Servlet implementation class Showadd
 */
@WebServlet("/showadd")
public class Showadd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Showadd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		boolean res,result;
		try(PrintWriter out=response.getWriter())
		{
			String user = CKUtil.get((HttpServletRequest) request, "auth_user");
			String Date=request.getParameter("date");
			String time=request.getParameter("time");

			res=Showservice.insert(user,Date,time);
			if(res==false)
			{
				out.println("Not Inserted");
			}
			else
			{
				out.write("inserted");
				response.sendRedirect("seat.html");
	
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
