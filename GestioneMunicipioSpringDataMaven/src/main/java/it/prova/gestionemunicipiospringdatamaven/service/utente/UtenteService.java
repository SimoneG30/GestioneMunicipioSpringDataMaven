package it.prova.gestionemunicipiospringdatamaven.service.utente;

import java.util.List;

import it.prova.gestionemunicipiospringdatamaven.model.Utente;

public interface UtenteService {
	
	public List<Utente> listAllUtenti() ;

	public Utente caricaSingoloUtente(Long id);

	public void aggiorna(Utente utenteInstance);

	public void inserisciNuovo(Utente utenteInstance);

	public void rimuovi(Utente utenteInstance);

	public List<Utente> findByExample(Utente example);
	
	public Utente eseguiAccesso(String username, String password);

	public List<Utente> findByNome(String nameInput);
	
	public List<Utente> cercaUtentiPerNomeAndCognome(String nomeInput, String cognomeInput);

	public List<Utente> cercaPerUsernameCheIniziaCon(String usernameInput);

	public List<Utente> cercaPerUsernameAndPassword(String usernameInput, String passwordInput);


}
