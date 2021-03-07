package it.prova.gestionemunicipiospringdatamaven.service.utente;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import it.prova.gestionemunicipiospringdatamaven.model.StatoUtente;
import it.prova.gestionemunicipiospringdatamaven.model.Utente;
import it.prova.gestionemunicipiospringdatamaven.repository.utente.UtenteRepository;

@Component
public class UtenteServiceImpl implements UtenteService {

	@Autowired
	private UtenteRepository repository;
	
	@PersistenceContext
	private EntityManager entityManager;

	@Transactional(readOnly = true)
	public List<Utente> listAllUtenti() {
		return (List<Utente>) repository.findAll();
	}

	@Transactional(readOnly = true)
	public Utente caricaSingoloUtente(Long id) {
		return repository.findById(id).orElse(null);
	}

	@Transactional
	public void aggiorna(Utente utenteInstance) {
		repository.save(utenteInstance);
	}

	@Transactional
	public void inserisciNuovo(Utente utenteInstance) {
		repository.save(utenteInstance);
	}

	@Transactional
	public void rimuovi(Utente utenteInstance) {
		repository.delete(utenteInstance);

	}

	@Transactional(readOnly = true)
	public List<Utente> findByExample(Utente example) {
		String query = "select u from Utente u where u.id = u.id ";

		if (StringUtils.isNotEmpty(example.getNome()))
			query += " and u.nome like '%" + example.getNome() + "%' ";
		if (StringUtils.isNotEmpty(example.getCognome()))
			query += " and u.cognome like '%" + example.getCognome() + "%' ";
		if (StringUtils.isNotEmpty(example.getUsername()))
			query += " and u.username = " + example.getUsername();
		if (StringUtils.isNotEmpty(example.getPassword()))
			query += " and u.password like '%" + example.getPassword() + "%' ";

		return entityManager.createQuery(query, Utente.class).getResultList();
	}
	

	@Transactional(readOnly = true)
	public Utente eseguiAccesso(String username, String password) {
		return repository.findByUsernameAndPasswordAndStato(username, password,StatoUtente.ATTIVO);
	}

	@Override
	public List<Utente> findByNome(String nameInput) {
		return repository.findByNome(nameInput);
	}

	@Override
	public List<Utente> cercaUtentiPerNomeAndCognome(String nomeInput, String cognomeInput) {
		return repository.findByNomeAndCognome(nomeInput, cognomeInput);
	}

	@Override
	public List<Utente> cercaPerUsernameCheIniziaCon(String usernameInput) {
		return repository.findByUsernameStartsWith(usernameInput);
	}

	@Override
	public List<Utente> cercaPerUsernameAndPassword(String usernameInput, String passwordInput) {
		return repository.findByUsernameAndPassword(usernameInput, passwordInput);
	}

}
