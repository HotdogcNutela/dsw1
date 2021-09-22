<%@ page contentType="text/html" pageEncoding="UTF-8"%>

<html>
	<head>
		<title>Cliente</title>
	</head>
	<body>
		<h2>Bem-vindo à área do cliente!!</h2>
		<%
			String contextPath = request.getContextPath().replace("/", "");
		%>
		<a href="/<%=contextPath%>/index.jsp">Página inicial</a>
	</body>
</html>
