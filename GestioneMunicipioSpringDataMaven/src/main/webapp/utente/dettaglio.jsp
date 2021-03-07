<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
    <%@page import="it.prova.gestionemunicipiospringdatamaven.model.Utente"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
}

	th, td {
	  padding: 10px;
	}
	.center {
		margin-left: auto;
		margin-right: auto;
	}
</style>
</head>
<body style = "background-color:lightblue; font-family: Segoe UI,Frutiger,Frutiger Linotype,Dejavu Sans,Helvetica Neue,Arial,sans-serif;">
	<table class="center">
		<thead>
			<tr>
				<th>Nome</th>
				<th>Cognome</th>
				<th>Username</th>
				<th>Data Registrazione</th>
			</tr>
		</thead>
		<% Utente utenteDaServlet = (Utente) request.getAttribute("utenteDettaglioAttribute"); %>
				<tr>
					<td><%=utenteDaServlet.getNome() %></td>
					<td><%=utenteDaServlet.getCognome() %></td>
					<td><%=utenteDaServlet.getUsername() %></td>
					<td><%=utenteDaServlet.getDataRegistrazione() %> </td>
				</tr>	
	</table>
</body>
</html>