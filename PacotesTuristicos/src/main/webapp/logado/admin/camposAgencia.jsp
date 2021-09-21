<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<table border="1">
	<caption>
		Cadastro de agência
	</caption>
	<tr>
		<td><label for="nome">Nome</label></td>
		<td><input type="text" id="nome" name="nome" size="45"
			required value="${agencia.nome}" /></td>
	</tr>
	<tr>
		<td><label for="email">Email</label></td>
		<td><input type="text" id="email" name="email" size="45"
			required value="${agencia.email}" /></td>
	</tr>
	<tr>
		<td><label for="senha">Senha</label></td>
		<td><input type="text" id="senha" name="senha" size="45" required
			value="${agencia.senha}" /></td>
	</tr>
	<tr>
		<td><label for="cnpj">CNPJ</label></td>
		<td><input type="text" id="cnpj" name="cnpj" size="45" required
			value="${agencia.cnpj}" /></td>
	</tr>
	<tr>
		<td><label for="descricao">Descrição</label></td>
		<td><input type="text" id="descricao" name="descricao" size="45" required
			value="${agencia.descricao}" /></td>
	</tr>
	<tr>
		<td colspan="2" align="center"><input type="submit" value="Salva" /></td>
	</tr>
</table>