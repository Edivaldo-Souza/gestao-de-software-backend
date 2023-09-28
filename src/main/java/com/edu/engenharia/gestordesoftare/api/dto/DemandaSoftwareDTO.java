package com.edu.engenharia.gestordesoftare.api.dto;

import javax.validation.constraints.NotBlank;

public class DemandaSoftwareDTO {
	@NotBlank(message="titulo nao pode ser vazio")
	private String titulo;
	@NotBlank(message="titulo nao pode ser vazio")
	private String descricao;
	private String dataEntrega;
	private String dateEncerramento;
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
	public String getDataEntrega() {
		return dataEntrega;
	}
	public void setDataEntrega(String dataEntrega) {
		this.dataEntrega = dataEntrega;
	}
	public String getDateEncerramento() {
		return dateEncerramento;
	}
	public void setDateEncerramento(String dateEncerramento) {
		this.dateEncerramento = dateEncerramento;
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
}
