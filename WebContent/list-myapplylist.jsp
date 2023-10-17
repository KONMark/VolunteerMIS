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
<%! String pageURL1="header-all.jsp"; %>
<jsp:include page="<%= pageURL1 %>"/>
	<center>
	<table border="1" bgcolor="#FFFAFA">
	<tr>
	<td>活动编号:</td>
	<td>活动名称:</td>
	<td>学号:</td>
	<td>姓名:</td>
	<td>报名状态:</td>
	<td>活动通知:</td>
	<td><p style="color:#FF6347"><b>签到状态:</b></p></td>
	</tr>
	<tr>
	<c:forEach var="al" items="${result}">
	<td>${al.apno}</td>
	<td>${al.aname}</td>
	<td>${al.aid}</td>
	<td>${al.name}</td>
	<td>${al.action}</td>
	<td><a href='${pageContext.request.contextPath}/NewsServlet_select?nno=${al.apno}&ano=${al.apno}&apno=${al.apno}&aid=${al.aid}' target="_blank">通知</a></td>
	<td>${al.asign}</td>
	<form action="${pageContext.request.contextPath}/ApplyServlet_updateasign" method="post">
	<input type="hidden" name="aid" value="${al.aid}"/>
	<input type="hidden" name="apno" value="${al.apno}"/>
	<td><input type="submit" value="签到"/></td></form>
	<form action="${pageContext.request.contextPath}/ApplyServlet_cancelasign" method="post">
	<input type="hidden" name="aid" value="${al.aid}"/>
	<input type="hidden" name="apno" value="${al.apno}"/>
	<td><input type="submit" value="取消"/></td></form>
	</tr>
	</c:forEach>
	</table>
	</center>
	<br>
<%! String pageURL3="footer.jsp"; %>
<jsp:include page="<%= pageURL3 %>"/>
</body>
</html>