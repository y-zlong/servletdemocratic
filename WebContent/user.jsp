<%@page import="SelectTest.UserBean"%>
<%@page import="java.util.List"%>
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
	   List<UserBean> u = (List<UserBean>)request.getAttribute("User");
	%>
	<table border="1" cellpadding="10" cellspacing="1">
		<tr>
			<th>id</th>
			<th>name</th>
			<th>number</th>
			<th>adress</th>
			<th>delete</th>
		</tr>
		<%
			for(UserBean user:u){
		%>
		<tr>
			<td><%=user.getUid()%></td>
			<td><%=user.getName() %></td>
			<td><%=user.getNumber()%></td>
			<td><%=user.getDress()%></td>
			<td><a href = "DelServlet?userId=<%=user.getUid()%>">delete</a></td>
		</tr>
		<% 		
			}
		%>
	</table>
</body>
</html>