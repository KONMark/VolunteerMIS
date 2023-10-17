<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>校青志社团管理系统</title>
</head>
<body>
<% %>
<%! String pageURL1="header-hello.jsp"; %>
<jsp:include page="<%= pageURL1 %>"/>
<%! String pageURL2="member-body.jsp"; %>
<jsp:include page="<%= pageURL2 %>"/>
<%! String pageURL3="footer.jsp"; %>
<jsp:include page="<%= pageURL3 %>"/>
</body>
</html>