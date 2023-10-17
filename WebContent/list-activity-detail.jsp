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
<body style="background:#FFFACD">
<p><center style="color:#000000;font-size:25px">欢迎进入志愿者学院！</center>
<div><p style="color:#000000">欢迎您，${id}&nbsp;${name}同学！</div><hr/>
	<center>
	<table border="1" style="background:#FFFFF0">
	<caption><p style="font-size:20px"><b>志愿活动详细信息</b></p></caption>
	<c:forEach var="ai" items="${result}">
	<tr>
	<td>活动编号:</td>
	<td>${ai.ano}</td>
	</tr>
	<tr>
	<td>活动名称:</td>
	<td>${ai.aname}</td>
	</tr>
	<tr>
	<td>集合时间:</td>
	<td>${ai.atime}</td>
	</tr>
	<tr>
	<td>集合地点:</td>
	<td>${ai.aposition}</td>
	</tr>
	<tr>
	<td>活动人数:</td>
	<td>${ai.apeople}</td>
	</tr>
	<tr>
	<td>活动时长:</td>
	<td>${ai.aduration}</td>
	</tr>
	<tr>
	<td>带队队长:</td>
	<td>${ai.acaptation}</td>
	</tr>
	<tr>
	<td>活动状态:</td>
	<td>${ai.astatus}</td>
	</tr>
	<tr>
	<td height="100">活动内容:</td>
	<td>${ai.acontext}</td>
	</tr>
	</c:forEach>
	</table>
	</center>
	<br>
<hr/>
</body>
</html>