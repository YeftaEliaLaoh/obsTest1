package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.Enumeration;
import java.util.Map;
import java.util.HashMap;

public class DetailServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
        
        Object req = request.getParameter("id");
        Map<String,String>  map = new HashMap();
        map.put("S1", "Name : A");
        map.put("S2", "Name : B");
        map.put("S3", "Name : C");
        map.put("S4", "Name : D");
        map.put("S5", "Name : E");
        map.put("S6", "Name : F");
        map.put("S7", "Name : G");
        map.put("S7", "Name : H");
        map.put("S8", "Name : I");
        
        if(map.get(req) != null)
        	out.print(map.get(req));
        else
        	out.print("Not Found");
	}

}
