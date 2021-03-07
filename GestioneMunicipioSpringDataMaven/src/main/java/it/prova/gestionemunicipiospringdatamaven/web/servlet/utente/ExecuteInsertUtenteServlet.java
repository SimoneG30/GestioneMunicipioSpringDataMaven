package it.prova.gestionemunicipiospringdatamaven.web.servlet.utente;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import it.prova.gestionemunicipiospringdatamaven.dto.UtenteDTO;
import it.prova.gestionemunicipiospringdatamaven.model.Utente;
import it.prova.gestionemunicipiospringdatamaven.service.utente.UtenteService;

@WebServlet("/ExecuteInsertUtenteServlet")
public class ExecuteInsertUtenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private UtenteService utenteService;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}


	public ExecuteInsertUtenteServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nomeInput = request.getParameter("nomeInput");
		String cognomeInput = request.getParameter("cognomeInput");
		String usernameInput = request.getParameter("usernameInput");
		String passwordInput = request.getParameter("passwordInput");
		UtenteDTO utenteDTO = new UtenteDTO(nomeInput, cognomeInput, usernameInput, passwordInput);
		
		List<String> utenteErrors = utenteDTO.errors();
		if (!utenteErrors.isEmpty()) {
			request.setAttribute("utenteAttribute", utenteDTO);
			request.setAttribute("utenteErrors", utenteErrors);
			request.getRequestDispatcher("/utente/insert.jsp").forward(request, response);
			return;
		}
		
		Utente utenteInstance = UtenteDTO.buildModelFromDto(utenteDTO);
		utenteService.inserisciNuovo(utenteInstance);
		
		request.setAttribute("messaggioConferma", "Inserimento avvenuto con successo");
		request.setAttribute("listaUtenti", utenteService.listAllUtenti());
		request.getRequestDispatcher("/utente/results.jsp").forward(request, response);
	}

}
