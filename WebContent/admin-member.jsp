<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户管理</title>
</head>
<body>
<%@ include file="admin-header.jsp" %>
<table style="background:#e5ffcc" border=0 cellspacing=10 cellpadding=10 width="100%">
<form action="${pageContext.request.contextPath}/MemberServlet_selectmymember" method="post">
	<input type="hidden" name="id" value="${id}">
	<tr>
	<td>
	<p align="center"><input type="submit" value="我的信息查询"></p>
	</td>
</form>
<form action="${pageContext.request.contextPath}/ApplyServlet_selectme" method="post">
	<input type="hidden" name="aid" value="${id}">
	<td>
	<p align="center"><input type="submit" value="我参加的活动"></p>
	</td>
</form>
<form action="${pageContext.request.contextPath}/MemberServlet_selectallmembers" method="post">
	<td>
	<p align="center"><input type="submit" style="background:#e5ffcc" value="所有用户管理"></p>
	</td>
</form>
</tr>
	</table>
	<br>
	<center><a href="${pageContext.request.contextPath}/admin-main.jsp"><b><p style="font-size:17px">返回</p></b></a></center>
<%! String pageURL3="footer.jsp"; %>
<%@ include file="footer.jsp" %>	
</body>
</html>