<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<table border="1">
	<caption>
		Cadastro de pacote
	</caption>
	<tr>
		<td><label for="nome">Nome</label></td>
		<td><input type="text" id="nome" name="nome" size="45"
			required value="${pacote.nome}" /></td>
	</tr>
	<tr>
		<td><label for="cidade">Cidade</label></td>
		<td><input type="text" id="cidade" name="cidade" size="45"
			required value="${pacote.cidade}" /></td>
	</tr>
	<tr>
		<td><label for="estado">Estado</label></td>
		<td><input type="text" id="estado" name="estado" size="45" required
			value="${pacote.estado}" /></td>
	</tr>
	<tr>
		<td><label for="pais">País</label></td>
		<td><input type="text" id="pais" name="pais" size="45" required
			value="${pacote.pais}" /></td>
	</tr>
	<tr>
		<td><label for="partida">Partida</label></td>
		<td><input type="date" id="partida" name="partida" size="45" required
			value="${pacote.partida}" /></td>
	</tr>
	<tr>
		<td><label for="duracao">Duração</label></td>
		<td><input type="number" id="duracao" name="duracao" size="45" required
			value="${pacote.duracao}" /></td>
	</tr>
	<tr>
		<td><label for="valor">Valor</label></td>
		<td><input type="number" id="valor" name="valor" size="45" required
			value="${pacote.valor}" /></td>
	</tr>
	<tr>
		<td><label for="descricao">Descrição</label></td>
		<td><input type="file" name="descricao" /></td>
	</tr>
	<tr>
		<td colspan="2" align="center"><input type="submit" value="Salva" /></td>
	</tr>
</table>