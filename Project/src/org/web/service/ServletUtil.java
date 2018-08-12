package org.web.service;

import javax.servlet.http.Part;

	public class ServletUtil {
		public static String extract(Part part){
			String content = part.getHeader("content-disposition");
			String[] items = content.split(";");
			for(String s : items){
				if(s.trim().startsWith("filename"))
					return s.substring(s.indexOf("=") + 2, s.length()-1);
			}
			return "";
		}	

}
