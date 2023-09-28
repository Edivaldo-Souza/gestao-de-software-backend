package com.edu.engenharia.gestordesoftare.api.dto;

import java.util.UUID;

public class UsuarioDTO {
	private UUID uuid;
	private String nome;
	private String contato;
	private String email;
	private int tipoUsuario;
	public UUID getUuid() {
		return uuid;
	}
	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getContato() {
		return contato;
	}
	public void setContato(String contato) {
		this.contato = contato;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getTipoUsuario() {
		return tipoUsuario;
	}
	public void setTipoUsuario(int tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	
	
}
