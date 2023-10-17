<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>报名填写</title>
<style>
img{
	title:校青志标志;width:100px;height:100px;right:0px;top:0px;z-index:100;position:absolute;
}
</style>
</head>
<body style="background:#FFFACD">
<p><center style="color:#000000;font-size:25px">欢迎进入志愿者学院！</center><img src=".\qingzhi.png"/>
<div><p style="color:#000000">欢迎您，${id}&nbsp;${name}同学！</div><hr/>
<table style="background:#ffffff" border=0 cellspacing=10 cellpadding=10 width="100%">
<center><a href="${pageContext.request.contextPath}/list-activity.jsp">返回</a></center><br>
	<form action="${pageContext.request.contextPath}/ApplyServlet_apply" method="post">
	  	<center><b>报名信息表</b></center>
	  	<center><p style="color:#FF3030">请确认信息后再报名！</p></center>
		<center>活动编号：<input type="text" name="apno" size="25" value="${ano}"/><br><br>
				活动名称：<input type="text" name="aname" size="25" value="${aname}"/><br><br>
				学号：<input type="text" name="aid" size="25" value="${id}"/><br><br>
				姓名：<input type="text" name="name" size="25" value="${name}"/><br><br>
				<input type="hidden" name="action" value="待审核"/>
				<input type="hidden" name="asign" value="未签到"/>
				<input type="hidden" name="feedback" value=" "/>
				<center>${message}</center><br>
		<center><input type="submit" value="报名"/>&nbsp;&nbsp;&nbsp;
		
			<br><hr/>
		</form>
</body>
</html>