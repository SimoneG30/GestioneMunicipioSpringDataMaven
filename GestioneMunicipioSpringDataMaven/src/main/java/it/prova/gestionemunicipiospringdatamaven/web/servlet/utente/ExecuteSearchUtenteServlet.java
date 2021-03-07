package it.prova.gestionemunicipiospringdatamaven.web.servlet.utente;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import it.prova.gestionemunicipiospringdatamaven.model.Utente;
import it.prova.gestionemunicipiospringdatamaven.service.utente.UtenteService;

@WebServlet("/ExecuteSearchUtenteServlet")
public class ExecuteSearchUtenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private UtenteService utenteService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

	public ExecuteSearchUtenteServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nomeInput = StringUtils.isNotEmpty(request.getParameter("nomeInput"))? request.getParameter("nomeInput"):null;
		String cognomeInput = StringUtils.isNotEmpty(request.getParameter("cognomeInput"))? request.getParameter("cognomeInput"):null;
		String usernameInput = StringUtils.isNotEmpty(request.getParameter("usernameInput"))? request.getParameter("usernameInput"):null;
		String passwordInput = StringUtils.isNotEmpty(request.getParameter("passwordInput"))? request.getParameter("passwordInput"):null;
		
		request.setAttribute("listaUtenti",
				utenteService.findByExample(new Utente(nomeInput, cognomeInput, usernameInput, passwordInput)));

		RequestDispatcher rd = request.getRequestDispatcher("/utente/results.jsp");
		rd.forward(request, response);

	}

}
