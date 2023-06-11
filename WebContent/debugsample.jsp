<%@page import="servlets.models.PostDepartment"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.ArrayList"%>
<%@page import="servlets.models.PostDepartment"%>
<%@page import="servlets.models.PostData"%>
<%@page import="java.text.DecimalFormat"%>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="https://code.jquery.com/jquery-1.10.2.js" type="text/javascript"></script>
<script>
function popup(mylink, windowname, w, h){
    if (! window.focus)return true;
    var href;
    if (typeof(mylink) == 'string')
       href=mylink;
    else
       href=mylink.href;
    window.open(href, windowname, "width="+w+",height="+h+",scrollbars=yes,toolbar=no" );
    return false;
}
</script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sample JSP Page for Debugging </title>
</head>
<body>

<%
String st = request.getParameter("name");


%>
<table>
    <tr>
        <th>Department</th>
        <th>Student ID</th>
        <th>Marks</th>
        <th>Pass %</th>
        
    </tr>
<%
DecimalFormat df = new DecimalFormat("####0.00");

ArrayList<PostDepartment> posts=(ArrayList<PostDepartment>) request.getAttribute("list"); 
for(PostDepartment post: posts)
	{ %>
	<tr>
		<td><%out.print(post.getDepartment());%></td>
	<%
	int pass = 0,j = 0;
	ArrayList<PostData> data = (ArrayList) post.getPostData();
	for(int i=0;i<data.size();i++){
		if(data.get(i).getMarks() >= 40){
			pass += data.get(i).getMarks();
			j++;
		}
		if(i==0){%>
				<td><a href="#" onClick="return popup('DetailServlet/?id=<%out.print(data.get(i).getStudentID());%>', 'Title', '400', '500')"><%out.print(data.get(i).getStudentID());%></a></td>
				<td><%out.print(data.get(i).getMarks());%></td>
		<%
		}
		else{%>
		
				<td></td>
				<td><a href="#" onClick="return popup('DetailServlet/?id=<%out.print(data.get(i).getStudentID());%>', 'Title', '400', '500')"><%out.print(data.get(i).getStudentID());%></a></td>
				<td><%out.print(data.get(i).getMarks());%></td>
		<%}

		if(i == data.size()-1)
		{
			if(j > 0){%>
				<td><%out.print(df.format((pass / j) * 100));%></td>
			<%}else{%>
				<td><%out.print(0);%></td>	
			<% }
		}
		%>
		</tr>		
<% 
	}
}
%>
</table>
</body>
</html>
