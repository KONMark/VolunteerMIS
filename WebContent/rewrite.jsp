<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>修改页面</title>
</head>
<body>
	<center style="font-size:25px">修改密码</center>
	<hr/><center><a href="${pageContext.request.contextPath}/login.jsp">返回</a></center><br>
	<form action="${pageContext.request.contextPath}/MemberServlet_updatepassword" method="post">
	  	<center><b>个人信息</b></center><br>
		<center>学号：<input type="text" name="id" size="20"/><br><br>
				姓名：<input type="text" name="name" size="20"/><br><br><br>
				修改密码：<input type="text" name="password" size="20" placeholder="修改密码"/><br><br></center>
				<center>${message}</center><br>
		<center><input type="submit" value="修改"/>&nbsp;&nbsp;&nbsp;
			<input type="reset" value="取消"/></center>
			<br><hr/>
		</form>
		
	</body>
</html>