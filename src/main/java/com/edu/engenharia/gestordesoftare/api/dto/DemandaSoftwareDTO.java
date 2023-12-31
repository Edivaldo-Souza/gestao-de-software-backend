package com.edu.engenharia.gestordesoftare.api.dto;

import java.util.UUID;

import javax.validation.constraints.NotBlank;

public class DemandaSoftwareDTO {
	@NotBlank(message="titulo nao pode ser vazio")
	private String titulo;
	@NotBlank(message="titulo nao pode ser vazio")
	private String descricao;
	private UUID uuid;
	private UUID uuidCliente;
	private UUID uuidDev;
	private String dataCriacao;
	private String dataEncerramento;
	private int prioridade; 
	private int situacao;
	private int prazo;
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
	public String getDataCriacao() {
		return dataCriacao;
	}
	public void setDataCriacao(String dataEntrega) {
		this.dataCriacao = dataEntrega;
	}
	public String getDataEncerramento() {
		return dataEncerramento;
	}
	public void setDataEncerramento(String dateEncerramento) {
		this.dataEncerramento = dateEncerramento;
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
	public int getPrazo() {
		return prazo;
	}
	public void setPrazo(int prazo) {
		this.prazo = prazo;
	}
	public UUID getUuid() {
		return uuid;
	}
	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}
	public UUID getUuidCliente() {
		return uuidCliente;
	}
	public void setUuidCliente(UUID uuidCliente) {
		this.uuidCliente = uuidCliente;
	}
	public UUID getUuidDev() {
		return uuidDev;
	}
	public void setUuidDev(UUID uuidDev) {
		this.uuidDev = uuidDev;
	}
	
}
