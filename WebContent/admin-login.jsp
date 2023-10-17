<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录页面</title>
<style>
</style>
</head>
<body>
	<%!
		String adminusername;
	%>
	<%
	Cookie[] cookies2=request.getCookies();
	if(cookies2!=null&&cookies2.length>=0){
		for(Cookie cookie2:cookies2){
			if(cookie2.getName().equals("adminusername")){
				adminusername=cookie2.getValue();
			}
		}
	}
	%>
	<center style="font-size:25px">用户登录</center><p align="right" style="font-size:12px"><a href="login.jsp" >切换学员登录</a></p>
	<hr/>
	<br>
	<form action="${pageContext.request.contextPath}/MemberServlet_adminlogin" method="post">
		<center>学号：<input type="text" name="id" size="20" placeholder="请输入学号" value=<%=(adminusername==null?"":adminusername)%>></center><br>
		<center>密码：<input type="password" name="password" size="21" placeholder="请输入密码" /></center><br>
		<center>${judge}</center><br>
		<center><input type="checkbox" name="adminusername" value="adnminusername"/>记住用户名<br><br></center>
		<center><a href="${pageContext.request.contextPath}/register.jsp">注册</a>&nbsp;&nbsp;&nbsp;
		<a href="${pageContext.request.contextPath}/rewrite.jsp">找回密码</a>&nbsp;&nbsp;&nbsp;
		<a href="${pageContext.request.contextPath}/MemberServlet_selectallmember" target="_blank">查看所有</a>
		<br><br>
		<center><input type="submit" value="登录"/>&nbsp;&nbsp;&nbsp;
			<input type="reset" value="取消"/></center>
		</form>
	</body>
</html>