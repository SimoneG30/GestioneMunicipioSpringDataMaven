package it.prova.gestionemunicipiospringdatamaven.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import it.prova.gestionemunicipiospringdatamaven.model.Utente;

public class UtenteDTO {

	private Long id;
	private String nome;
	private String cognome;
	private String username;
	private String password;
	private Date dataRegistrazione;

	public UtenteDTO() {
	}

	public UtenteDTO(String nome, String cognome, String username, String password) {
		this.nome = nome;
		this.cognome = cognome;
		this.username = username;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}	
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}	

	public Date getDataRegistrazione() {
		return dataRegistrazione;
	}

	public void setDataRegistrazione(Date dataRegistrazione) {
		this.dataRegistrazione = dataRegistrazione;
	}

	public List<String> errors(){
		List<String> result = new ArrayList<String>();
		if(StringUtils.isBlank(this.nome))
			result.add("Il campo nome non può essere vuoto");
		if(StringUtils.isBlank(this.cognome))
			result.add("Il campo cognome non può essere vuoto");
		if(StringUtils.isBlank(this.username))
			result.add("Il campo username non può essere vuoto");
		if(StringUtils.isBlank(this.password))
			result.add("Il campo password non può essere vuoto");
		return result;
	}

	public static Utente buildModelFromDto(UtenteDTO utenteDTO) {
		Utente result = new Utente();
		result.setId(utenteDTO.getId());
		result.setNome(utenteDTO.getNome());
		result.setCognome(utenteDTO.getCognome());
		result.setUsername(utenteDTO.getUsername());
		result.setPassword(utenteDTO.getPassword());
		result.setDataRegistrazione(new Date());
		return result;
	}

}
