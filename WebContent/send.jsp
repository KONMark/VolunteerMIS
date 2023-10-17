<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>发布活动</title>
<style>
img{
	title:校青志标志;width:100px;height:100px;right:0px;top:0px;z-index:100;position:absolute;
}
</style>
</head>
<body style="background:#ccffcc">
	<center style="color:black;font-size:25px">发布活动</center><img src=".\qingzhi.png"/><br>
	<div><p style="color:black">欢迎您，${id}&nbsp;${name}同学！</div>
	<hr/><center><a href="${pageContext.request.contextPath}/list-volunteerinfo-manage.jsp">返回</a></center><br>
	<form action="${pageContext.request.contextPath}/ActivityServlet_sendActivity" method="post">
	  	<center><b>志愿活动信息</b></center><br>
		<center>活动编号：<input type="text" name="ano" size="25" onkeyup="no.value=this.value"/><br><br>
				<input type="hidden" name="nno" id="no"/>
				<input type="hidden" name="inform" value="通知还未编辑，请耐心等待......"/>
				活动名称：<input type="text" name="aname" size="25" value="${aname}"/><br><br>
				活动时间：<input type="text" name="atime" size="25" value="${atime}"/><br><br>
				活动地点：<input type="text" name="aposition" size="25" value="${aposition}"/><br><br>
				活动人数：<input type="text" name="apeople" size="25"/><br><br>
				活动时长：<input type="text" name="aduration" size="25" value="${aduration}"/><br><br>
				带队队长：<input type="text" name="acaptation" size="25"/><br><br>
				<input type="hidden" name="astatus" value="进行中" size="25"/>
				活动内容：<textarea name="acontext" rows="5" cols="20" style="overflow:auto;">${acontext}</textarea><br><br>
				<center>${message}</center><br>
		<center><input type="submit" value="发布"/>&nbsp;&nbsp;&nbsp;
			<input type="reset" value="取消"/></center>
			<br><hr/>
		</form>
		
	</body>
</html>