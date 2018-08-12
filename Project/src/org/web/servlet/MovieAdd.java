package org.web.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.web.service.MovieService;
import org.web.service.ServletUtil;

/**
 * Servlet implementation class MovieAdd
 */
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, maxFileSize =1024 * 1024 * 10, maxRequestSize = 1024 * 1024 * 50)
public class MovieAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MovieAdd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		try(PrintWriter out=response.getWriter())
		{
			String movieName=request.getParameter("movie");
			String actor=request.getParameter("actor");
			String actress=request.getParameter("actress");
			String release=request.getParameter("releasedate");
			String director=request.getParameter("director");
			//String path=request.getParameter("url");
			String screen=request.getParameter("screenstatus");
			String fclass=request.getParameter("fclass");
			String sclass=request.getParameter("sclass");
			String tclass=request.getParameter("tclass");
			Part part=request.getPart("url"); 
			String location = getServletConfig().getInitParameter("storage");
			String proof = ServletUtil.extract(part);
			part.write(location + File.separator + proof);
			MovieService movieservice=new MovieService();
			int t1=Integer.parseInt(fclass);
			int t2=Integer.parseInt(sclass);
			int t3=Integer.parseInt(tclass);
			boolean res=movieservice.insert(movieName, actor, actress, release,director,proof,screen,t1,t2,t3);
			if(res==true)
			{
				response.sendRedirect("addmovie.html");
			
			}
			else
			{
				out.println("");
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
