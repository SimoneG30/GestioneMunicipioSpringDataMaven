package it.prova.gestionemunicipiospringdatamaven.web.servlet.utente;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import it.prova.gestionemunicipiospringdatamaven.service.utente.UtenteService;

@WebServlet("/ExecuteTestSpringDataUtenteServlet")
public class ExecuteTestSpringDataUtenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private UtenteService utenteService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

	public ExecuteTestSpringDataUtenteServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String codiceOperazione = request.getParameter("codop");
		String queryInput = request.getParameter("queryInput");

		Object resultFromQuery = null;

		switch (codiceOperazione) {
		case "findByName":
			resultFromQuery = utenteService.findByNome(queryInput);
			break;

		case "findByNomeAndCognome":
			resultFromQuery = utenteService.cercaUtentiPerNomeAndCognome(queryInput,
					request.getParameter("queryInputCognome"));
			break;

		case "findByUsername":
			resultFromQuery = utenteService.cercaPerUsernameCheIniziaCon(queryInput);
			break;
			
		case "findByUsernameAndPassword":
			resultFromQuery = utenteService.cercaPerUsernameAndPassword(queryInput, 
					request.getParameter("queryInputPassword"));
			break;

		default:
			break;
		}

		String result = resultFromQuery == null ? "" : resultFromQuery.toString();

		response.getWriter().append("Risultato: =====>>> " + codiceOperazione).append("\n").append(result);
	}

}
