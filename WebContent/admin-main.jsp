<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>管理员图书管理系统</title>
</head>
<body>
<%@ include file="admin-header.jsp" %>
<table style="background:#e5ffcc" border=0 cellspacing=10 cellpadding=10 width="100%">
	<tr>
	<td>
	<p align="center"><b><a href="${pageContext.request.contextPath}/admin-member.jsp">用户管理</a></b></p>
	</td>
	<td>
	<p align="center"><b><a href="${pageContext.request.contextPath}/admin-volunteer.jsp">志愿信息库</a></b></p>
	</td>
	<td>
	<p align="center"><b><a href="${pageContext.request.contextPath}/volunteer-admin.jsp">志愿者学院</a></b></p>
	</td>
	</tr>
	</table>
<%@ include file="footer.jsp" %>	
<center><a href="${pageContext.request.contextPath}/main.jsp"><b><p style="font-size:17px">退出</p></b></a></center>
</body>
</html>