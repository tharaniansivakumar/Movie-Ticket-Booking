package org.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.web.modal.Show;
import org.web.modal.util.CKUtil;
import org.web.service.CustomerLogService;
import org.web.service.SeatAdminService;
import org.web.service.SeatService;
import org.web.service.Showservice;

/**
 * Servlet implementation class SeatAdd
 */
@WebServlet("/seatadd")
public class SeatAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SeatAdd() {
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
			String user = CKUtil.get((HttpServletRequest) request, "auth_user");
			String[] value=request.getParameterValues("names");
			 List list =  Arrays.asList(value); 
			 SeatAdminService seat=new SeatAdminService();
			 SeatService s=new SeatService();
			 CustomerLogService cust=new CustomerLogService();
			 Showservice show=new Showservice();
			 Show ser=show.retrive(user);
			 boolean res =seat.insert(user, list,ser.getDate(),ser.getShowTime());
			 boolean r=s.create(user,value);
			 boolean result=s.seatadd(user,list);
			 boolean resu=cust.insert(user); 
			 if(resu==true)
			{
				 out.write("inserted");
				 response.sendRedirect("Ticket.html");
			}
			 else
			 {
				 out.write("not inserted");
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
