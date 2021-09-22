<%@ page contentType="text/html" pageEncoding="UTF-8"%>

<html>
	<head>
		<title>Admin</title>
	</head>
	<body>
		<h2>Bem-vindo à área administrativa!!</h2>
		<%
			String contextPath = request.getContextPath().replace("/", "");
		%>
		<a href="/<%=contextPath%>/admin/cadastroCliente">Cadastrar cliente</a><br/>
		<a href="/<%=contextPath%>/admin/cadastroAgencia">Cadastrar agência</a><br/>
		<a href="/<%=contextPath%>/admin/listaClientes">Listar clientes</a><br/>
		<a href="/<%=contextPath%>/admin/listaAgencias">Listar agências</a><br/>
		<a href="/<%=contextPath%>/index.jsp">Página inicial</a>
	</body>
</html>
