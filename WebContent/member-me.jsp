<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>个人信息查询</title>
</head>
<body>
<%! String pageURL1="header-hello.jsp"; %>
<jsp:include page="<%= pageURL1 %>"/>
<table style="background:#ffffff" border=0 cellspacing=10 cellpadding=10 width="100%">
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
	</tr>
</form>
	</table>
	<br>
	<center><a href="${pageContext.request.contextPath}/member-hello.jsp"><b><p style="font-size:17px">返回</p></b></a></center>
<%! String pageURL3="footer.jsp"; %>
<jsp:include page="<%= pageURL3 %>"/>
</body>
</html>