<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html>
<!-- <fmt:bundle basename="message"> -->
	<head>
		<title>Lista de agências</title>
	</head>
	<body>
		<%
			String contextPath = request.getContextPath().replace("/", "");
		%>
		<a href="/<%=contextPath%>/admin">Área administrativa</a>
		<div align="center">
			<h1>Agências</h1>
		</div>
		<div align="center">
			<table border="1">
				<tr>
					<th>ID</th>
					<th>Nome</th>
					<th>E-mail</th>
					<th>Senha</th>
					<th>CNPJ</th>
					<th>Descrição</th>
					<th>Ações</th>
				</tr>
				<c:forEach var="agencia" items="${requestScope.listaAgencias}">
					<tr>
						<td><c:out value="${agencia.id}" /></td>
						<td><c:out value="${agencia.nome}" /></td>
						<td><c:out value="${agencia.email}" /></td>
						<td><c:out value="${agencia.senha}" /></td>
						<td><c:out value="${agencia.cnpj}" /></td>
						<td><c:out value="${agencia.descricao}" /></td>
						<td><a href="/<%= contextPath %>/admin/atualizaAgencia?id=<c:out value='${agencia.id}' />">Editar</a> 
                        			&nbsp;&nbsp;&nbsp;&nbsp;
                            			<a href="/<%= contextPath %>/admin/removeAgencia?id=<c:out value='${agencia.id}' />"
									onclick="return confirm('Tem certeza que deseja excluir esta agência?');">
									Remover</a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</body>
<!-- </fmt:bundle> -->
</html>
