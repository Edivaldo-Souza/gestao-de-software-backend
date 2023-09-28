package com.edu.engenharia.gestordesoftare.domain.entities;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_demandas")
public class DemandaSoftware {
	@Id
	private long id;
	private UUID uuid;
	private UUID uuidCliente;
	private UUID uuidDev;
	private String titulo;
	private String descricao;
	private String dataEntrega;
	private String dataEncerramento;
	// baixa=0; media=1; alta=2 
	private int prioridade;
	// em_processamento=0; concluida=1
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
	public String getDataEntrega() {
		return dataEntrega;
	}
	public void setDataEntrega(String dataEntrega) {
		this.dataEntrega = dataEntrega;
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
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
