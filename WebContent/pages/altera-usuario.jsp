<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<c:url value="/alteraEmpresa" var="linkServletNovaEmpresa"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Alterar usuário</title>
</head>
<body>

	<form action="/PrimeiroProjetoWeb/usuarios" method="post">
	
		Nome: <input type="text" name="nome" value="${usuario.nome }" />
		CPF: <input type="text" name="cpf" value="${usuario.cpf }" />
		<input type="hidden" name="id" value="${usuario.idUsuario }">
		<input type="hidden" name="acao" value="alterar">
		<input type="submit" value= "Alterar"/>
	</form>

</body>
</html>