package com.edu.engenharia.gestordesoftare.domain.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.engenharia.gestordesoftare.domain.entities.Tarefa;
import com.edu.engenharia.gestordesoftare.domain.repository.TarefaRepository;

@Service
public class TarefaService {
	@Autowired
	TarefaRepository repository;
	
	public Tarefa create(Tarefa t) {
		t.setUuid(UUID.randomUUID());
		
		return repository.save(t);
	}
	
	public boolean delete(UUID uuid) {
		Tarefa t = repository.findByUuid(uuid);
		if(t!=null) {
			repository.delete(t);
			return true;
		}
		else return false;
		
	}
	
	public List<Tarefa> searchAll(){
		return repository.findAll();
	}
	
	public List<Tarefa> searchByUuidDemanda(UUID id){
		return repository.findByUuidDemanda(id);
	}
}
