<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="com.etc.entity.Article"%>
<%@page import="java.util.List"%>
<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>ShowArticle</title>
</head>
<body>

<div align="center">
<h1>i'm model,${pageContext.request.servletPath}</h1>

	<c:forEach items="${map}" var="ma" >
	${ma.key }
	${ma.value }
	
	</c:forEach>


</div>

</body>
</html>