package com.edu.engenharia.gestordesoftare.api.dto;

import java.util.UUID;

public class AtualizarDemandaDTO {
	private UUID uuid;
	private UUID uuidDev;
	private String dataEncerramento;
	private int prioridade; 
	private int situacao;
	private int prazo;
	public UUID getUuid() {
		return uuid;
	}
	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}
	public UUID getUuidDev() {
		return uuidDev;
	}
	public void setUuidDev(UUID uuidDev) {
		this.uuidDev = uuidDev;
	}
	public int getPrioridade() {
		return prioridade;
	}
	public void setPrioridade(int prioridade) {
		this.prioridade = prioridade;
	}
	public int getSituacao() {
		return situacao;
	}
	public void setSituacao(int situacao) {
		this.situacao = situacao;
	}
	public String getDataEncerramento() {
		return dataEncerramento;
	}
	public void setDataEncerramento(String dataEncerramento) {
		this.dataEncerramento = dataEncerramento;
	}
	public int getPrazo() {
		return prazo;
	}
	public void setPrazo(int prazo) {
		this.prazo = prazo;
	}
	
}
