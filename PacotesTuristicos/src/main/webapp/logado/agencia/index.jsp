<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>

<html>
	<head>
		<title>Agência</title>
	</head>
	<body>
		<h2>Bem-vindo à área da agência!!</h2>
		<%
			String contextPath = request.getContextPath().replace("/", "");
		%>
		<a href="/<%=contextPath%>/pacote/cadastroPacote">Cadastrar pacotes turísticos</a><br/>
		<a href="/<%=contextPath%>/pacote/listaPacotesAgencia">Listar pacotes turísticos</a><br/>
		<a href="/<%=contextPath%>/index.jsp">Página inicial</a>
	</body>
</html>
