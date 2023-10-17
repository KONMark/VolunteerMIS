<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>人员替换</title>
</head>
<body style="background:#ccffcc">
	<center style="color:black;font-size:25px">欢迎进入校青志社团管理系统</center>
	<div><p style="color:black">欢迎您，${id}&nbsp;${name}同学！</div><hr/>
	<form action="${pageContext.request.contextPath}/ApplyServlet_exchange" method="post">
	  	<center><b>替换名单</b></center><br>
		<center>活动编号：<input type="text" name="apno" size="25" value="${apno}"/><br><br>
				活动名称：<input type="text" name="aname" size="25" placeholder="活动名称"/><br><br>
				学号：<input type="text" name="aid" size="25" placeholder="替换人学号"/><br><br>
				姓名：<input type="text" name="name" size="25" placeholder="替换人姓名"/><br><br>
				<input type="hidden" name="action" value="待审核" size="25"/>
				<input type="hidden" name="feedback" value=" " size="25"/>
				<input type="hidden" name="asign" value="未签到" size="25"/>
				<center>${message}</center><br>
		<center><input type="submit" value="确认"/>&nbsp;&nbsp;&nbsp;
			<input type="reset" value="取消"/></center>
			<br><hr/>
		</form>
		
	</body>
</html>