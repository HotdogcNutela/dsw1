<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<table border="1">
	<caption>
		Cadastro de cliente
	</caption>
	<tr>
		<td><label for="nome">Nome</label></td>
		<td><input type="text" id="nome" name="nome" size="45" required 
			value="${cliente.nome}" /></td>
	</tr>
	<tr>
		<td><label for="email">Email</label></td>
		<td><input type="text" id="email" name="email" size="45" required 
			value="${cliente.email}" /></td>
	</tr>
	<tr>
		<td><label for="senha">Senha</label></td>
		<td><input type="password" id="senha" name="senha" size="45" required
			value="${cliente.senha}" /></td>
	</tr>
	<tr>
		<td><label for="cpf">CPF</label></td>
		<td><input type="text" id="cpf" name="cpf" size="45" required
			value="${cliente.cpf}" /></td>
	</tr>
	<tr>
		<td><label for="telefone">Telefone</label></td>
		<td><input type="text" id="telefone" name="telefone" size="45" required
			value="${cliente.telefone}" /></td>
	</tr>
	<tr>
		<td><label for="sexo">Sexo</label></td>
		<td><input type="text" id="sexo" name="sexo" size="45" required
			value="${cliente.sexo}" /></td>
	</tr>
	<tr>
		<td><label for="dNasc">Data de Nascimento</label></td>
		<td><input type="text" id="dNasc" name="dNasc" size="45" required
			value="${cliente.dNasc}" /></td>
	</tr>
	<tr>
		<td colspan="2" align="center"><input type="submit" value="Cadastrar" /></td>
	</tr>
</table>