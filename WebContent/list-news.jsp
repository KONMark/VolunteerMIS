<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <jsp:useBean id="Member" class="com.club.entity.Member" scope="session"/> --%>
<%@ page import="com.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>活动界面</title>
<style>
img{
	title:校青志标志;width:100px;height:100px;right:0px;top:0px;z-index:100;position:absolute;
}
</style>
</head>
<body style="background:#FFFACD">
<p><center style="color:#000000;font-size:25px">欢迎进入志愿者学院！</center><img src=".\qingzhi.png"/><br>
<div><p style="color:#000000">欢迎您，${id}&nbsp;${name}同学！</div><hr/>
	<center>
	<table border="1" style="background:#FFFFF0">
	<caption><p style="font-size:20px"><b>活动界面</b></p></caption>
	<c:forEach var="ai" items="${result2}">
	<tr>
	<td>活动编号:</td>
	<td>${ai.ano}</td>
	</tr>
	<tr>
	<td>活动名称:</td>
	<td>${ai.aname}</td>
	</tr>
	<tr>
	<td>集合时间:</td>
	<td>${ai.atime}</td>
	</tr>
	<tr>
	<td>集合地点:</td>
	<td>${ai.aposition}</td>
	</tr>
	<tr>
	<td>活动人数:</td>
	<td>${ai.apeople}</td>
	</tr>
	<tr>
	<td>活动时长:</td>
	<td>${ai.aduration}</td>
	</tr>
	<tr>
	<td>带队队长:</td>
	<td>${ai.acaptation}</td>
	</tr>
	<tr>
	<td>活动状态:</td>
	<td>${ai.astatus}</td>
	</tr>
	<tr>
	<td height="100">活动内容:</td>
	<td>${ai.acontext}</td>
	</tr>
	</c:forEach>
	<tr>
	<td height="100">通知信息:</td>
	<td><textarea name="feedback" rows="5" cols="50" style="overflow:auto;" readonly>${inform}</textarea></td>
	</tr>
	<tr>
	<td>反思反馈：</td>
	<form action="${pageContext.request.contextPath}/ApplyServlet_feedback" method="post">
	<input type="hidden" name="nno" value="${apno}"/>
	<input type="hidden" name="apno" value="${apno}"/>
	<input type="hidden" name="ano" value="${apno}"/>
	<input type="hidden" name="aid" value="${aid}"/>
	<td><textarea name="feedback" rows="10" cols="50" style="overflow:auto;" placeholder="请在活动完成后填写反思反馈，不少于100，不多于300...">${feedback}</textarea><br>
	<center><p style="font-size:15px">${message}</p></center>
	<center><input type="submit" value="提交"/>&nbsp;&nbsp;&nbsp;<input type="reset" value="重置"/></center></td>
	</tr>
	</table>
	</center>
	<br>
<hr/>
</body>
</script>
</html>