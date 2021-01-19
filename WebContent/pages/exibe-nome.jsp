<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	Bem vindo ${nome} e tenho ${idade} anos
	<br>
	<c:forEach items="${modulos}" var="item">
	 	<%-- <c:if test="${item.cargaHoraria != 60}">
			${item.nome} ${item.cargaHoraria} <br>
		</c:if> --%>
		${item.nome} ${item.cargaHoraria} <br>
	</c:forEach>
</body>
</html>