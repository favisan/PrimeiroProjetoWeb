<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri ="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
<meta charset="UTF-8">
<title>Lista de Usuários</title>
</head>
<body>
	<td><a href="/PrimeiroProjetoWeb/usuarios?acao=novo">Novo usuário</a></td>
	<table>
	<tr>
		<th>ID</th>
		<th>NOME</th>
		<th>CPF</th>
		<th>DT NASCIMENTO</th>
	</tr>
		<c:forEach items="${users}" var="user">
				<tr>
					<td>${user.idUsuario}</td>
					<td>${user.nome}</td>
					<td>${user.cpf}</td>
					<td><fmt:formatDate value ="${user.dtNascimento}" pattern= "dd/MM/yyyy"/></td>
					<td><a href="/PrimeiroProjetoWeb/usuarios?acao=editar&id=${ user.idUsuario }">editar</a></td>
					<td><a href="/PrimeiroProjetoWeb/usuarios?acao=remover&id=${ user.idUsuario }">remover</a></td>
				</tr>
		</c:forEach>
	</table>
</body>
</html>