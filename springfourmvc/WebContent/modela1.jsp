<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>modela1.jsp</h1>
<div align="center">
	${pageContext.request.pathInfo }
		<h1>re:${requestScope.list }</h1>
		<h1>se:${sessionScope.list }</h1>
		<h1>a:${requestScope.a }</h1>
		<input type="text" />
	</div>

</body>
</html>