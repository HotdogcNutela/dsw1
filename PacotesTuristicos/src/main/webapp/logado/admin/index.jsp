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
		<a href="/<%=contextPath%>/admin/listaClientes">Lista de clientes</a><br/>
		<a href="/<%=contextPath%>/admin/listaAgencias">Lista de agências</a><br/>
		<a href="/<%=contextPath%>/admin/atualizaCliente">Editar cliente</a><br/>
		<a href="/<%=contextPath%>/admin/atualizaAgencia">Editar agência</a><br/>
		<a href="/<%=contextPath%>/admin/removeCliente">Remover cliente</a><br/>
		<a href="/<%=contextPath%>/admin/removeAgencia">Remover agência</a>
	</body>
</html>
