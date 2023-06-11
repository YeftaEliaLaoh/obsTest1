package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlets.models.*;

public class LoginServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		//request.getRequestDispatcher("link.html").include(request, response);

		String userid = request.getParameter("userid");
		String password = request.getParameter("password");
		if (password.equals("admin")) {
			out.print("Welcome, " + userid);
			HttpSession session = request.getSession();
			session.setAttribute("name", userid);
			PostData postData1 = new PostData();
			postData1.setStudentID("S1");
			postData1.setMarks(35);
			PostData postData2 = new PostData();
			postData2.setStudentID("S2");
			postData2.setMarks(70);
			PostData postData3 = new PostData();
			postData3.setStudentID("S3");
			postData3.setMarks(60);
			PostData postData4 = new PostData();
			postData4.setStudentID("S4");
			postData4.setMarks(90);
			PostData postData5 = new PostData();
			postData5.setStudentID("S5");
			postData5.setMarks(30);		
			ArrayList<PostData> post1 = new ArrayList<PostData>();
			post1.add(postData1);
			post1.add(postData2);
			post1.add(postData3);
			post1.add(postData4);
			post1.add(postData5);
			PostDepartment postDepartment1 = new PostDepartment();
			postDepartment1.setDepartment("Dep 1");
			postDepartment1.setPostData(post1);

			PostData postData6 = new PostData();
			postData6.setStudentID("S6");
			postData6.setMarks(32);
			ArrayList<PostData> post2 = new ArrayList<PostData>();
			post2.add(postData6);
			PostDepartment postDepartment2 = new PostDepartment();
			postDepartment2.setDepartment("Dep 2");
			postDepartment2.setPostData(post2);
			
			PostData postData7 = new PostData();
			postData7.setStudentID("S7");
			postData7.setMarks(70);
			PostData postData8 = new PostData();
			postData8.setStudentID("S8");
			postData8.setMarks(20);
			ArrayList<PostData> post3 = new ArrayList<PostData>();
			post3.add(postData7);
			post3.add(postData8);
			PostDepartment postDepartment3 = new PostDepartment();
			postDepartment3.setDepartment("Dep 3");
			postDepartment3.setPostData(post3);
			
			ArrayList<PostDepartment> list = new ArrayList<PostDepartment>();
			list.add(postDepartment1);
			list.add(postDepartment2);
			list.add(postDepartment3);
			request.setAttribute("list", list);
			
			request.getRequestDispatcher("debugsample.jsp")
			.include(request,response);
		} else {
			out.print("Sorry, username or password error!");
		}
		out.close();
	}

}
