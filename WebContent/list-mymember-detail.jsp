<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <jsp:useBean id="Member" class="com.club.entity.Member" scope="session"/> --%>
<%@ page import="com.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>个人详细信息</title>
</head>
<body>
<%@ include file="admin-header.jsp" %>
	<center>
	<table border="1" style="background:#e5ffcc">
	<caption><p style="font-size:20px"><b>个人详细信息</b></p></caption>
	<c:forEach var="mb" items="${result}">
	<tr>
	<td>学号:</td>
	<td>${mb.id}</td>
	</tr>
	<tr>
	<td>姓名:</td>
	<td>${mb.name}</td>
	</tr>
	<tr>
	<td>部门:</td>
	<td>${mb.depart}</td>
	</tr>
	<tr>
	<td>职务:</td>
	<td>${mb.duty}</td>
	</tr>
	<tr>
	<td>性别:</td>
	<td>${mb.sex}</td>
	</tr>
	<tr>
	<td>电话:</td>
	<td>${mb.tele}</td>
	</tr>
	<tr>
	<td>班级:</td>
	<td>${mb.mclass}</td>
	</tr>
	<tr>
	<td>微信:</td>
	<td>${mb.wechat}</td>
	</tr>
	<tr>
	<td>参加次数:</td>
	<td>${mb.join_num}</td>
	</tr>
	<tr>
	<td>个人时长:</td>
	<td>${mb.join_time}</td>
	</tr>
	<tr>
	<td>签到状态:</td>
	<td>${asign}</td>
	</tr>
	<tr>
	<td>反思反馈：</td>
	<td><textarea rows="10" cols="50" style="overflow:auto;" placeholder="这位同学还没完成反思反馈哦" readonly>${feedback}</textarea>
	</td>
	<form action="${pageContext.request.contextPath}/MemberServlet_submit" method="post">
	<input type="hidden" name="join_time" value="${join_time}">
	<input type="hidden" name="id" value="${mb.id}"/>
	<input type="hidden" name="aid" value="${aid}"/>
	<input type="hidden" name="apno" value="${apno}"/>
	<tr>
	<td colspan="2"><center>${message}<br><input type="submit" value="确认完成" style="background:#FF4500"></center></td>
	</tr>
	</form>
	</c:forEach>
	</table>
	</center>
	<br>
<hr/>
</body>
</html>