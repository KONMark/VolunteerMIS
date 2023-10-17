<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <jsp:useBean id="Member" class="com.club.entity.Member" scope="session"/> --%>
<%@ page import="com.*"%>
<%@ page import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>志愿者学院</title>
</head>
<body>
<%@ include file="header-volunteer.jsp" %>
	<center>
	<table border="1" style="background:#FFFFF0">
	<caption><p style="font-size:20px">志愿活动</p></caption>
	<tr>
	<td>活动编号:</td>
	<td>活动名称:</td>
	<td>集合时间:</td>
	<td>活动人数:</td>
	<td>活动时长:</td>
	<td>活动状态:</td>
	</tr>
	<tr>
	<c:forEach var="ai" items="${result}">
	<td>${ai.ano}</td>
	<td><a href='${pageContext.request.contextPath}/ActivityServlet_detail?ano=${ai.ano}' target="_blank">${ai.aname}</a></td>
	<td>${ai.atime}</td>
	<td>${ai.apeople}</td>
	<td>${ai.aduration}</td>
	<td>${ai.astatus}</td>
	<td>
	<form action="${pageContext.request.contextPath}/ApplyServlet_toaddapply" method="post">
		<input type="hidden" name="ano" value="${ai.ano}"/>
		<input type="hidden" name="aname" value="${ai.aname}"/>
		<input type="submit" value="报名">
	</form>
	</td>
	</tr>
	</c:forEach>
	</table>
	</center>
	<br>
<hr/>
</body>
</html>