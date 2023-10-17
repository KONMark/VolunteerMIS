<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <jsp:useBean id="Member" class="com.club.entity.Member" scope="session"/> --%>
<%@ page import="com.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>注册信息</title>
</head>
<body>
<%! String pageURL1="header-all.jsp"; %>
<jsp:include page="<%= pageURL1 %>"/>
	<center><p style="font-size:20px">我的个人信息
	<table border="1" bgcolor="#FFFAFA">
	<tr>
	<td>学号:</td>
	<td>密码:</td>
	<td>姓名:</td>
	<td>部门:</td>
	<td>职务:</td>
	<td>性别:</td>
	<td>电话:</td>
	<td>专业:</td>
	<td>微信:</td>
	<td>生日:</td>
	<td>活动次数:</td>
	<td>时长:</td>
	<td>宿舍:</td>
	</tr>
	<tr>
	<c:forEach var="mb" items="${result}">
	<td>${mb.id}</td>
	<td>${mb.password}</td>
	<td>${mb.name}</td>
	<td>${mb.depart}</td>
	<td>${mb.duty}</td>
	<td>${mb.sex}</td>
	<td>${mb.tele}</td>
	<td>${mb.mclass}</td>
	<td>${mb.wechat}</td>
	<td>${mb.birth}</td>
	<td>${mb.join_num}</td>
	<td>${mb.join_time}</td>
	<td>${mb.dorm}</td>
	</tr>
	</c:forEach>
	</table>
	</center>
	<br>
<%! String pageURL3="footer.jsp"; %>
<jsp:include page="<%= pageURL3 %>"/>
</body>
</html>