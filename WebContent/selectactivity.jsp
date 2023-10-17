<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>活动信息查询</title>
<style>
img{
	title:校青志标志;width:100px;height:100px;right:0px;top:0px;z-index:100;position:absolute;
}
</style>
</head>
<body style="background:#FFFACD">
	<center style="color:black;font-size:25px">活动信息查询</center><img src=".\qingzhi.png"/><br>
	<div><p style="color:black">欢迎您，${id}&nbsp;${name}同学！</div><hr/><br>
	<form action="${pageContext.request.contextPath}/ActivityServlet_condition" method="post">
		<center>活动名称：<input type="text" name="aname" size="25"/><br><br>
				活动时间：<input type="text" name="atime" size="25"/><br><br>
				活动状态：<select name="astatus" style = "width:180px;">
						<option value=''></option>
						<option value='进行中'>进行中</option>
						<option value='已截止'>已截止</option>
				</select><br><br>
		<center><input type="submit" value="查询"/>&nbsp;&nbsp;&nbsp;
			<input type="reset" value="取消"/></center>
			<br><hr/>
		</form>
		
	</body>
</html>