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
		String uname;
	%>
	<%
	Cookie[] cookies1=request.getCookies();
	if(cookies1!=null&&cookies1.length>=0){
		for(Cookie cookie1:cookies1){
			if(cookie1.getName().equals("uname")){
				uname=cookie1.getValue();
			}
		}
	}
	%>
	<center style="font-size:25px">用户登录</center><p align="right" style="font-size:12px"><a href="admin-login.jsp" >切换管理员登录</a></p>
	<hr/>
	<br>
	<form action="${pageContext.request.contextPath}/MemberServlet_memberlogin" method="post">
		<center>学号：<input type="text" name="id" size="20" placeholder="请输入学号" value=<%=(uname==null?"":uname)%>></center><br>
		<center>密码：<input type="password" name="password" size="21" placeholder="请输入密码" /></center><br>
		<center>${judge}</center><br>
		<center><input type="checkbox" name="checkusername" value="checkusername"/>记住用户名<br><br></center>
		<center><a href="${pageContext.request.contextPath}/register.jsp">注册</a>&nbsp;&nbsp;&nbsp;
		<a href="${pageContext.request.contextPath}/rewrite.jsp">找回密码</a>&nbsp;&nbsp;&nbsp;
		<a href="${pageContext.request.contextPath}/MemberServlet_selectallmember" target="_blank">查看所有</a>
		<br><br>
		<center><input type="submit" value="登录"/>&nbsp;&nbsp;&nbsp;
			<input type="reset" value="取消"/></center>
		</form>
	</body>
</html>