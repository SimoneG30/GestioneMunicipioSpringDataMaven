<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Risultati Ricerca</title>
<link rel="shortcut icon" href="${pageContext.request.contextPath}/favicon.ico" type="image/x-icon" />
</head>
<body>

	<div class="container">

		<%@ include file="../header.jsp"%>

		<div class="page-header">
			<h3>Pagina dei Risultati</h3>
		</div>

		<table class="table table-striped">
			<thead>
				<tr>
					<th>Id</th>
					<th>Nome</th>
					<th>Cognome</th>
					<th>Username</th>
					<th>Password</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${listaUtenti}" var="utentiItem">
					<tr>
						<td>${utentiItem.id }</td>
						<td>${utentiItem.nome }</td>
						<td>${utentiItem.cognome }</td>
						<td>${utentiItem.username }</td>
						<td>${utentiItem.password }</td>
						<td><a
							href="ExecuteDettaglioUtenteServlet?idUtente=${utentiItem.id }"
							class="btn btn-info">Dettaglio</a> <a
							href="PrepareModificaUtenteServlet?idUtente=${utentiItem.id }"
							class="btn btn-info">Modifica</a></td>
					</tr>
				</c:forEach>


			</tbody>

		</table>

	</div>
</body>
</html>