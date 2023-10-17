<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <jsp:useBean id="Member" class="com.club.entity.Member" scope="session"/> --%>
<%@ page import="com.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>志愿者学院</title>
</head>
<body>
<%@ include file="admin-header.jsp" %>
	<center>
	<table border="1" style="background:#e5ffcc">
	<caption><p style="font-size:20px">志愿活动管理</p></caption>
	<tr>
	<td>活动编号:</td>
	<td>活动名称:</td>
	<td>集合时间:</td>
	<td>集合地点:</td>
	<td>活动人数:</td>
	<td>活动时长:</td>
	<td>带队队长:</td>
	<td>活动状态:</td>
	<td width="200" >活动内容</td>
	</tr>
	<tr>
	<c:forEach var="ai" items="${result}">
	<td>${ai.ano}</td>
	<td><a href='${pageContext.request.contextPath}/ApplyServlet_selectall?apno=${ai.ano}&aduration=${ai.aduration}' target="_blank">${ai.aname}</a></td>
	<td>${ai.atime}</td>
	<td>${ai.aposition}</td>
	<td>${ai.apeople}</td>
	<td>${ai.aduration}</td>
	<td>${ai.acaptation}</td>
	<td>${ai.astatus}</td>
	<td>${ai.acontext}</td>
	<td>
	<form action="${pageContext.request.contextPath}/ActivityServlet_end" method="post">
		<input type="hidden" name="ano" value="${ai.ano}">
		<input type="submit" value="截止">
	</form>
	</td>
	<td>
	<form action="/VolunteerMIS/ActivityServlet_delete" method="post">
			<input type="hidden" name="ano" value="${ai.ano}">
			<input type="hidden" name="nno" value="${ai.ano}">
			<input type="submit" value="删除">
	</form>
	</td>
	</tr>
	</c:forEach>
	</table>
	</center>
	<br>
	<center><a href='/VolunteerMIS/admin-volunteer.jsp'>返回</a>
<hr/>
</body>
</html>