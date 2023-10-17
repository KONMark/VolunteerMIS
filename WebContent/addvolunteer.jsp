<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>添加志愿信息</title>
<style>
img{
	title:校青志标志;width:100px;height:100px;right:0px;top:0px;z-index:100;position:absolute;
}
</style>
</head>
<body style="background:#ccffcc">
	<center style="color:black;font-size:25px">志愿信息添加</center><img src=".\qingzhi.png"/><br>
	<div><p style="color:black">欢迎您，${id}&nbsp;${name}同学！</div>
	<hr/><center><a href="${pageContext.request.contextPath}/admin-volunteer.jsp">返回</a></center><br>
	<form action="${pageContext.request.contextPath}/VolunteerServlet_add" method="post">
	  	<center><b>志愿基本信息</b></center><br>
		<center>活动编号：<input type="text" name="vno" size="25"/><br><br>
				活动名称：<input type="text" name="vname" size="25"/><br><br>
				活动时间：<input type="text" name="vtime" size="25"/><br><br>
				活动地点：<input type="text" name="vposition" size="25"/><br><br>
				活动人数：<input type="text" name="vpeople" size="25"/><br><br>
				活动时长：<input type="text" name="vduration" size="25"/><br><br>
				活动内容：<!-- <input type="text" name="vcontext" size="300" style="width:180px;height:50px"/> -->
				<textarea name="vcontext" rows="5" cols="20" style="overflow:auto;"></textarea><br><br>
				<center>${message}</center><br>
		<center><input type="submit" value="发布"/>&nbsp;&nbsp;&nbsp;
			<input type="reset" value="取消"/></center>
			<br><hr/>
		</form>
		
	</body>
</html>