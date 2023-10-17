<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>志愿者学院</title>
<script language="javascript"> 
//从服务器上获取初始时间 
	var currentDate = new Date(<%=new java.util.Date().getTime()%>); 
	function run() { 
		currentDate.setSeconds(currentDate.getSeconds()+1); 
		document.getElementById("dt").innerHTML = currentDate.toLocaleString();     
	} 
	window.setInterval("run();", 1000); 
</script>
<style>
img{
	title:校青志标志;width:100px;height:100px;right:0px;top:0px;z-index:100;position:absolute;
}
</style>
</head>
<body style="background:#FFFACD">
<p><center style="color:#000000;font-size:25px">欢迎进入志愿者学院！</center><img src=".\qingzhi.png"/>
<div><p style="color:#000000">欢迎您，${id}&nbsp;${name}同学！当前时间：<span id="dt"></span></div>
<hr/>
</body>
</html>