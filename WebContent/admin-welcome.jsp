<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Refresh" content="4;URL=admin-main.jsp">
<title>登录成功</title>
</head>
<body>
	${name}同学&nbsp;登录成功，请稍后......<br>
	<div id="timer"></div>
	<script>
		var time = 4
		setInterval(function(){    
		time--;    
		if(time === 0){        
			window.location.href = "admin-main.jsp"    
		}    
		document.querySelector("#timer").textContent = "剩余时间" + time + "秒"
		}, 1000)
	</script>
</body>
</html>