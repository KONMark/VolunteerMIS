<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>注册页面</title>
</head>
<body>
	<center style="font-size:25px">注册页面</center>
	<hr/><center><a href="${pageContext.request.contextPath}/login.jsp">返回</a></center><br>
	<form action="${pageContext.request.contextPath}/MemberServlet_register" method="post">
	  	<center><b>个人信息</b></center><br>
		<center>学号：<input type="text" name="id" size="20"/><br><br>
				密码：<input type="text" name="password" size="20"/><br><br>
				姓名：<input type="text" name="name" size="20"/><br><br>
				部门：<select name="depart" style = "width:150px;">
						<option value='秘书处'>秘书处</option>
						<option value='主席团'>主席团</option>
						<option value='文化宣传部'>文化宣传部</option>
						<option value='公关外事部'>公关外事部</option>
						<option value='媒体运营部'>媒体运营部</option>
						<option value='活动项目部'>活动项目部</option>
						<option value='学院管理部'>学院管理部</option>
						<option value='学院拓展部'>学院拓展部</option>
						<option value='服务队'>服务队</option>
						<option value='学员'>学员</option>
					  </select><br><br>
				职务：<input type="text" name="duty" size="20"/><br><br>
				性别：<select name="sex" style = "width:150px;">
						<option value='男'>男</option>
						<option value='女'>女</option>
					  </select><br><br>
				联系：<input type="text" name="tele" size="20"/><br><br>
				专业：<input type="text" name="mclass" size="20"/><br><br>
				微信：<input type="text" name="wechat" size="20"/><br><br>
	<%--活动次数--%><input type="hidden" name="join_num" value="0"/>
	<%--活动时长--%><input type="hidden" name="join_time" value="0"/>
				生日：<input type="text" name="birth" size="20"/><br><br>
				宿舍：<input type="text" name="dorm" size="20"/><br><br></center><br>
				<center>${message}</center><br>
		<center><input type="submit" value="注册"/>&nbsp;&nbsp;&nbsp;
			<input type="reset" value="取消"/></center>
			<br><hr/>
		</form>
		
	</body>
</html>