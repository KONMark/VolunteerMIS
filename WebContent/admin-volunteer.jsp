<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>志愿管理</title>
</head>
<body>
<%@ include file="admin-header.jsp" %>
<table style="background:#e5ffcc" border=0 cellspacing=10 cellpadding=10 width="100%">
<form action="${pageContext.request.contextPath}/VolunteerServlet_select" method="post">
	<tr>
	<td>
	<p align="center"><input type="submit" style="background:#e5ffcc" value="志愿信息库"></p>
	</td>
</form>
<form action="${pageContext.request.contextPath}/ActivityServlet_select2" method="post">
	<input type="hidden" name="ActivityFlag" value="manageActivity">
	<td>
	<p align="center"><input type="submit" style="background:#e5ffcc" value="志愿活动管理"></p>
	</td>
</form>
<form action="${pageContext.request.contextPath}/addvolunteer.jsp" method="post">
	<td>
	<p align="center"><input type="submit" style="background:#e5ffcc" value="添加志愿信息"></p>
	</td>
</form>
<!-- <form action="/VolunteerMIS/ApplyServlet" method="post"> -->
<!-- 	<input type="hidden" name="ApplyFlag" value="manageApply"> -->
<!-- 	<td> -->
<!-- 	<p align="center"><input type="submit" style="background:#e5ffcc" value="活动名单确认"></p> -->
<!-- 	</td> -->
<!-- </form> -->
	</tr>
</table>
	<br>
	<center><a href="${pageContext.request.contextPath}/admin-main.jsp"><b><p style="font-size:17px">返回</p></b></a></center>
<%! String pageURL3="footer.jsp"; %>
<%@ include file="footer.jsp" %>	
</body>
</html>