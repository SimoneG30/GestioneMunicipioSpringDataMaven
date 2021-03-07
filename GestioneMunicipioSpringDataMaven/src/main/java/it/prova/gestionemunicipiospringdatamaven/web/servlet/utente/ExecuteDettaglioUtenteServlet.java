package it.prova.gestionemunicipiospringdatamaven.web.servlet.utente;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import it.prova.gestionemunicipiospringdatamaven.service.utente.UtenteService;

import javax.servlet.ServletConfig;

@WebServlet("/ExecuteDettaglioUtenteServlet")
public class ExecuteDettaglioUtenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

	@Autowired
	private UtenteService utenteService;

	public ExecuteDettaglioUtenteServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Long utenteParametro = Long.parseLong(request.getParameter("idUtente"));

		try {
			request.setAttribute("utenteDettaglioAttribute", utenteService.caricaSingoloUtente(utenteParametro));
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("/utente/dettaglio.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
