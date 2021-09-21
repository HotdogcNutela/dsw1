<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html>
<!-- <fmt:bundle basename="message"> -->
	<head>
		<title>Lista de clientes</title>
	</head>
	<body>
		<%
			String contextPath = request.getContextPath().replace("/", "");
		%>
		<div align="center">
			<h1>Clientes</h1>
		</div>
		<div align="center">
			<table border="1">
				<tr>
					<th>ID</th>
					<th>Nome</th>
					<th>E-mail</th>
					<th>Senha</th>
					<th>CPF</th>
					<th>Telefone</th>
					<th>Sexo</th>
					<th>Data de nascimento</th>
				</tr>
				<c:forEach var="cliente" items="${requestScope.listaClientes}">
					<tr>
						<td><c:out value="${cliente.id}" /></td>
						<td><c:out value="${cliente.nome}" /></td>
						<td><c:out value="${cliente.email}" /></td>
						<td><c:out value="${cliente.senha}" /></td>
						<td><c:out value="${cliente.cpf}" /></td>
						<td><c:out value="${cliente.telefone}" /></td>
						<td><c:out value="${cliente.sexo}" /></td>
						<!-- TODO: acrescentar data de nascimento -->
					</tr>
				</c:forEach>
			</table>
		</div>
	</body>
<!-- </fmt:bundle> -->
</html>