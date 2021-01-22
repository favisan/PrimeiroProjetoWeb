<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Novo usuário</title>
</head>
<body>

	<form action="/PrimeiroProjetoWeb/usuarios" method="post">
	
		Nome: <input type="text" name="nome" />
		CPF: <input type="text" name="cpf" />
		<input type="hidden" name="acao" value="novo"/>
		
		<input type="submit" value= "Cadastrar"/>
	</form>

</body>
</html>