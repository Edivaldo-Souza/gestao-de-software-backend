package com.edu.engenharia.gestordesoftare.api.dto;

import java.util.UUID;

public class CriarDemandaDTO {
	private String titulo;
	private String descricao;
	private UUID uuidCliente;
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public UUID getUuidCliente() {
		return uuidCliente;
	}
	public void setUuidCliente(UUID uuidCliente) {
		this.uuidCliente = uuidCliente;
	}
	
	
}
