package com.edu.engenharia.gestordesoftare.domain.entities;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name="tb_tarefas")
public class Tarefa {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(updatable=false, nullable=false, columnDefinition="VARCHAR(36)")
	@Type(type="uuid-char")
	private UUID uuid;
	@Column(columnDefinition="VARCHAR(36)")
	@Type(type="uuid-char")
	private UUID uuidDemanda;
	private String texto;
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
