<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="kfmes.natelib.entity.*, java.util.List" %>
<%
	List<NateGroup> groups = (List<NateGroup>)request.getAttribute("groups");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script language="javascript" type="text/javascript">
function hello() {
}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>WateOn</title>
</head>
<body>
<H3>Login</H3>
<a href="LogoutServlet">Logout</a>

<br />
<br />

<%
	for (NateGroup group : groups) {
		out.println(group.getName() + "<ul>");
		for (NateFriend user : group.getList()) {
%>
			<li><%= user.getNameNick() %></li>
<%
		}
		out.println("</ul>");
	}
%>

</body>
</html>