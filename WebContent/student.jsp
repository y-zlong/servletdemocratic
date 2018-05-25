<%@page import="java.util.List"%>
<%@page import="ServletMVC.studentBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	 List<studentBean> stu =(List<studentBean>) request.getAttribute("student");
	%>
	<table cellpadding="10" cellspacing="0" border="1">
		<tr>
			<th>id</th>
			<th>name</th>
			<th>number</th>
			<th>dress</th>
			<th>Delet</th>
		</tr>
		<%
			for(studentBean student : stu){
		%>
			<tr>
				<td><%=student.getId() %></td>
				<td><%=student.getName() %></td>
				<td><%=student.getNumber() %></td>
				<td><%=student.getDress() %></td>
				<td><a href = "delServlet?<%=student.getId() %>">Delet</a></td>
			</tr>
		<% 		
			}
		%>
	</table>
</body>
</html>