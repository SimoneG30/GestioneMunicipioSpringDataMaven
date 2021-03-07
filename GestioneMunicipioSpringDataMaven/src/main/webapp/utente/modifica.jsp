<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	    <%@page import="it.prova.gestionemunicipiospringdatamaven.model.Utente"%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inserisci Nuovo Utente</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/jqueryUI/jquery-ui.min.css" />
<style>
.ui-autocomplete-loading {
	background: white url("img/anim_16x16.gif") right center no-repeat;
}
</style>
<link rel="shortcut icon" href="${pageContext.request.contextPath}/favicon.ico" type="image/x-icon" />
</head>
<body>

	<div class="container">
		<%@ include file="../header.jsp"%>
		<div class="page-header">
			<h3>Pagina di Inserimento Utente</h3>
		</div>
	<% Utente utenteInPagina = (Utente)request.getAttribute("utenteAttributeModifica"); %>

		<form class="form-horizontal" action="ExecuteModificaUtenteServlet"
			method="post">
			<div class="form-group">
				<label class="control-label col-sm-2" for="nomeInput">Nome:</label>
				<div class="col-sm-4">
					<input class="form-control" type="text" id="nomeInputId"
						name="nomeInput" value="<%=utenteInPagina.getNome()%>">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="cognomeInput">Cognome:</label>
				<div class="col-sm-4">
					<input class="form-control" type="text" id="cognomeInputId"
						name="cognomeInput" value="<%=utenteInPagina.getCognome()%>">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="usernameInput">Username:</label>
				<div class="col-sm-4">
					<input class="form-control" type="text" id="usernameInputId"
						name="usernameInput" value="<%=utenteInPagina.getUsername()%>">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="passwordInput">Password:</label>
				<div class="col-sm-4">
					<input class="form-control" type="text" id="passwordInputId"
						name="passwordInput" value="<%=utenteInPagina.getPassword()%>">
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-4">
					<input class="form-control" type="hidden" id="idUtenteId"
						name="idUtente" value="<%=utenteInPagina.getId()%>">
				</div>
			</div>

			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-primary btn-md">Effettua
						Modifica</button>
				</div>
			</div>	
		</form>
	</div>
	<!-- /.container -->



</body>


</html>