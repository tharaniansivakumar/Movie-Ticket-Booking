package org.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.web.modal.CustomerLog;
import org.web.modal.Screen;
import org.web.modal.util.CKUtil;
import org.web.service.CustomerLogService;
import org.web.service.CustomerMovieService;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


/**
 * Servlet implementation class Ticket
 */
@WebServlet("/ticket")
public class Ticket extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ticket() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try(PrintWriter out=response.getWriter())
		{
		String user = CKUtil.get((HttpServletRequest) request, "auth_user");
		CustomerLogService service=new CustomerLogService();
		List scr=(List) service.retrive(user);
		
		
		Gson gson =new Gson();
		GsonBuilder b = new GsonBuilder();
		b.registerTypeAdapterFactory(HibernteProxyTypeAdpter.FACTORY);
		gson = b.create();
		out.write(gson.toJson(scr));
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
