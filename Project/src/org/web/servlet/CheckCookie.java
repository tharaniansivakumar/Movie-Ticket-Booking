package org.web.servlet;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import org.web.modal.util.CKUtil;

/**
 * Servlet Filter implementation class CheckCookie
 */
@WebFilter(
		urlPatterns = { "/checkcookie","/seat.html","/CustomerMovie.html","/Ticket.html","/view.html" }, 
		servletNames = {  
				"Showadd", 
				"ScreenAdd",
				"SeatAdd",
				"Ticket",
				"ListMovie"
		})
public class CheckCookie implements Filter {

    /**
     * Default constructor. 
     */
    public CheckCookie() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		chain.doFilter(request, response);
		response.setContentType("text/html");
		String user = CKUtil.get((HttpServletRequest) request, "auth_user");
		System.out.println(user);
		if (user == null || user.isEmpty()) {
			request.getRequestDispatcher("index.html").include(request, response);
		} else {
			chain.doFilter(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
