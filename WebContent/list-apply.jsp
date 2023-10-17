<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <jsp:useBean id="Member" class="com.club.entity.Member" scope="session"/> --%>
<%@ page import="com.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>报名信息</title>
</head>
<body>
<%@ include file="admin-header.jsp" %>
	<center>
	<table border="1" style="background:#e5ffcc">
	<caption><p style="font-size:20px">报名信息</p></caption>
	<center><p style="font-size:15px;color:#FF6347">管理员请在公示报名情况5小时后再确认名单。
	<tr>
	<td>活动编号:</td>
	<td>活动名称:</td>
	<td>学号:</td>
	<td>姓名:</td>
	<td>报名状态:</td>
	<td>签到情况:</td>
	</tr>
	<tr>
	<c:forEach var="al" items="${result}">
	<td>${al.apno}</td>
	<td>${al.aname}</td>
	<td>${al.aid}</td>
	<td><a href='${pageContext.request.contextPath}/MemberServlet_detail?id=${al.aid}&apno=${al.apno}&aid=${al.aid}&aduration=${aduration}' target="_blank">${al.name}</td>
	<td>${al.action}</td>
	<td>${al.asign}</td>
	<td>
	<form action="${pageContext.request.contextPath}/ApplyServlet_yes" method="post">
		<input type="hidden" name="apno" value="${al.apno}">
		<input type="hidden" name="aid" value="${al.aid}">
		<input type="submit" value="通过">
	</form>
	</td>
	<td>
	<form action="${pageContext.request.contextPath}/ApplyServlet_no" method="post">
		<input type="hidden" name="apno" value="${al.apno}">
		<input type="hidden" name="aid" value="${al.aid}">
		<input type="submit" value="取消">
	</form>
	</td>
	<td>
	<form action="${pageContext.request.contextPath}/ApplyServlet_delete" method="post">
		<input type="hidden" name="apno" value="${al.apno}">
		<input type="hidden" name="aid" value="${al.aid}">
		<input type="hidden" name="ApplyFlag" value="delete">
		<input type="submit" value="删除">
	</form>
	</td>
	</tr>
	</c:forEach>
	</table><br>
	<center><a href='${pageContext.request.contextPath}/exchange.jsp?apno=${apno}' target="_blank">人员替换</a>&nbsp;&nbsp;
	<a href='${pageContext.request.contextPath}/NewsServlet_update?nno=${apno}' target="_blank">通知编辑</a>&nbsp;&nbsp;
	</center><br>
<hr/>
</body>
</html>