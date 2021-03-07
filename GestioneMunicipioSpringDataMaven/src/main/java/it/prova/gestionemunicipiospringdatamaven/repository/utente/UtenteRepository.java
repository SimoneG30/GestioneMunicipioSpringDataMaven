package it.prova.gestionemunicipiospringdatamaven.repository.utente;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import it.prova.gestionemunicipiospringdatamaven.model.StatoUtente;
import it.prova.gestionemunicipiospringdatamaven.model.Utente;

public interface UtenteRepository extends CrudRepository<Utente, Long>, QueryByExampleExecutor<Utente> {

	Utente findByUsernameAndPasswordAndStato(String username,String password, StatoUtente stato);

	List<Utente> findByNome(String name);

	List<Utente> findByNomeAndCognome(String nomeInput, String cognomeInput);

	@Query("from Utente u where u.username like ?1%")
	List<Utente> findByUsernameStartsWith(String usernameInput);

	List<Utente> findByUsernameAndPassword(String usernameInput, String passwordInput);
}
