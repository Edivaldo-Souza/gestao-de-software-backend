package com.edu.engenharia.gestordesoftare.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.edu.engenharia.gestordesoftare.domain.entities.DemandaSoftware;
import com.edu.engenharia.gestordesoftare.domain.repository.DemandaRepository;

import java.util.List;
import java.util.UUID;
import java.time.LocalDate;

@Service
public class DemandaSoftwareService {
	@Autowired
	private DemandaRepository repository;
	
	public List<DemandaSoftware> getAll(){
		List<DemandaSoftware> l = repository.findAll();
		return l;
	}
	
	public DemandaSoftware create(DemandaSoftware df) {
		df.setUuid(UUID.randomUUID());
		df.setUuidDev(UUID.randomUUID());
		df.setDataEncerramento("Em análise");
		
		return repository.save(df);
	}
	
	public List<DemandaSoftware> searchForAll() {
		return repository.findAll();
	}
	
	public List<DemandaSoftware> searchBySituacao(int i){
		return repository.findBySituacao(i);
	}
	
	public List<DemandaSoftware> searchByUuidCliente(UUID uuid) {
		return repository.findByUuidCliente(uuid);
	}
	
	public List<DemandaSoftware> searchByUuidDev(UUID uuid) {
		return repository.findByUuidDev(uuid);
	}
	
	public DemandaSoftware update(DemandaSoftware df) {
		DemandaSoftware d = repository.findByUuid(df.getUuid());
		
		df.setId(d.getId());
		df.setTitulo(d.getTitulo());
		df.setDescricao(d.getDescricao());
		df.setDataCriacao(d.getDataCriacao());
		df.setUuidCliente(d.getUuidCliente());
		return repository.save(df);
	}
	
	public DemandaSoftware encerrarDemanda(DemandaSoftware df) {
		DemandaSoftware d = repository.findByUuid(df.getUuid());
		
		df.setId(d.getId());
		df.setTitulo(d.getTitulo());
		df.setDescricao(d.getDescricao());
		df.setDataCriacao(d.getDataCriacao());
		df.setUuidCliente(d.getUuidCliente());
		df.setUuidDev(d.getUuidDev());
		df.setPrazo(d.getPrazo());
		df.setPrioridade(d.getPrioridade());
		return repository.save(df);
	}
	
	public boolean delete(UUID id) {
		DemandaSoftware ds = repository.findByUuid(id);
		if(ds!=null) {
			repository.delete(ds);
			return true;
		}
		else return false;
	}
}
