package com.edu.engenharia.gestordesoftare.api.dto;

import java.util.UUID;

public class TarefaDTO {
	private UUID uuid;
	private UUID uuidDemanda;
	private String texto;
	public UUID getUuid() {
		return uuid;
	}
	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}
	public UUID getUuidDemanda() {
		return uuidDemanda;
	}
	public void setUuidDemanda(UUID uuidDemanda) {
		this.uuidDemanda = uuidDemanda;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	
}
