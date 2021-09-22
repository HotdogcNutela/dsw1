<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>

<html>
	<head>
		<title>Agência</title>
	</head>
	<body>
		<h2>Bem-vindo à área da agência!!</h2>
		<h3>TODO: listar todos os pacotes da agência</h3>
		<%
			String contextPath = request.getContextPath().replace("/", "");
		%>
		<a href="/<%=contextPath%>/agencia/cadastro">Cadastrar pacote turístico</a>
		<a href="/<%=contextPath%>/index.jsp">Página inicial</a>
	</body>
</html>
