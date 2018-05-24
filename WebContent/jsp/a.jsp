<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>BBBBBBBBBBB</h1>

	<%-----<%@ include file = "b.jsp" %>  -->
	<jsp:include page="b.jsp"/>
	 --%>
	 <%--转发   页面的仍然停在a.jsp,等价于request.getRequestDispatcher("/jsp/b.jsp").forward(request, response);
	 <jsp:forward page="/jsp/b.jsp"></jsp:forward>
	 <%
	 	request.getRequestDispatcher("/jsp/b.jsp").forward(request, response);
	 %>
	  <jsp:forward page="/jsp/b.jsp">
	  	<jsp:param value="123456" name="username"/>
	  
	  </jsp:forward>
	  <jsp:include page="/jsp/b.jsp">
	  		<jsp:param value="123589" name="name"/>	
	  </jsp:include>
	  --%>
	  
	  <form action="b.jsp" method= "get">
	  	user:<input type="text" name="name"/>
	  	<input type="submit" value="Submit"/>
	  </form>
</body>
</html>