<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String targetId = (String)request.getAttribute("targetId");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>chat</title>
	<script language="javascript" type="text/javascript" src="js/jquery-1.3.2.min.js"></script>
	<script language="javascript" type="text/javascript" src="js/jquery.async.js"></script>
	<script language="javascript" type="text/javascript" src="js/jquery.form.js"></script>
	<script language="javascript" type="text/javascript" src="js/wateon.js"></script>
	<script language="javascript" type="text/javascript" src="js/chat.js"></script>
	<script language="javascript" type="text/javascript">
		$(document).ready(function() {
			startCheckMessageThread("<%= targetId %>");
		});
	</script>
</head>
<body>
	<p>상대방 아이디: <%= targetId %></p>
	<div id="chat_list">
	</div>

	<form method="post" action="">
	</form>
</body>
</html>