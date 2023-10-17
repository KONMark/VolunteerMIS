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
<%@ include file="header-all.jsp" %>
<body>
	<center>
	<table border="1" style="background:#FFFFF0">
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
	</tr>
	</c:forEach>
	</table>
	</center>
	<br>
<hr/>
</body>
</html>