<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>个人信息查询</title>
</head>
<body>
<%! String pageURL1="header-volunteer.jsp"; %>
<jsp:include page="<%= pageURL1 %>"/>
<table style="background:#FFFFF0" border=0 cellspacing=10 cellpadding=10 width="100%">
<form action="${pageContext.request.contextPath}/ActivityServlet_select1" method="post" target="_blank">
<input type="hidden" name="depart" value="${depart}">
<input type="hidden" name="ActivityFlag" value="selectactivity">
	<tr>
	<td>
	<p align="center"><input type="submit" value="志愿活动表"></p>
	</td>
</form>
<form action="${pageContext.request.contextPath}/VolunteerServlet_select2" method="post" target="_blank">
	<td>
	<p align="center"><input type="submit" value="志愿信息库"></p>
	</td>
</form>
<form action="${pageContext.request.contextPath}/selectactivity.jsp" method="post" target="_blank">
	<td>
	<p align="center"><input type="submit" value="志愿活动查询"></p>
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