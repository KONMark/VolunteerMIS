<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>通知编辑</title>
<style>
img{
	title:校青志标志;width:100px;height:100px;right:0px;top:0px;z-index:100;position:absolute;
}
</style>
</head>
<body style="background:#FFFACD">
<p><center style="color:#000000;font-size:25px">欢迎进入校青志社团管理系统</center><img src=".\qingzhi.png"/>
<div><p style="color:#000000">欢迎您，${id}&nbsp;${name}同学！</div><hr/>
<table style="background:#ffffff" border=0 cellspacing=10 cellpadding=10 width="100%">
	<form action="${pageContext.request.contextPath}/NewsServlet_add" method="post">
	  	<center><b>活动通知编辑</b></center>
		<center><input type="hidden" name="nno" size="25" value="${nno}"/><br><br>
				<textarea name="inform" rows="20" cols="50" style="overflow:auto;">${inform}</textarea><br><br>
				<center>${message}</center><br>
		<center><input type="submit" value="提交"/>&nbsp;&nbsp;&nbsp;
		<input type="reset" value="重置"/>
			<br><hr/>
		</form>
</body>
</html>