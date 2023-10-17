<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <jsp:useBean id="Member" class="com.club.entity.Member" scope="session"/> --%>
<%@ page import="com.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>志愿信息</title>
</head>
<%@ include file="admin-header.jsp" %>
<body>
	<center>
	<table border="1" style="background:#e5ffcc">
	<caption><p style="font-size:20px">志愿基本信息库</p></caption>
	<tr>
	<td>活动编号:</td>
	<td>活动名称:</td>
	<td>活动时间:</td>
	<td>活动地点:</td>
	<td>活动人数:</td>
	<td>活动时长:</td>
	<td width="200">活动内容:</td>
	</tr>
	<tr>
	<c:forEach var="vi" items="${result}">
	<td>${vi.vno}</td>
	<td>${vi.vname}</td>
	<td>${vi.vtime}</td>
	<td>${vi.vposition}</td>
	<td>${vi.vpeople}</td>
	<td>${vi.vduration}</td>
	<td>${vi.vcontext}</td>
	<td>
	<form action="${pageContext.request.contextPath}/ActivityServlet_send" method="post">
		<input type="hidden" name="aname" value="${vi.vname}">
		<input type="hidden" name="atime" value="${vi.vtime}">
		<input type="hidden" name="aposition" value="${vi.vposition}">
		<input type="hidden" name="aduration" value="${vi.vduration}">
		<input type="hidden" name="acontext" value="${vi.vcontext}">
		<input type="submit" value="发布"/>
	</form>
	</td>
	<td>
	<form action="${pageContext.request.contextPath}/VolunteerServlet_delete" method="post">
		<input type="hidden" name="vno" value="${vi.vno}">
		<input type="submit" value="删除"/>
	</form>
	</td>
	</tr>
	</c:forEach>
	</table>
	</center>
	<br>
	<center><a href='${pageContext.request.contextPath}/send.jsp'>发布</a>&nbsp;&nbsp;
	<a href='${pageContext.request.contextPath}/admin-volunteer.jsp'>返回</a></center>
<hr/>
</body>
</html>