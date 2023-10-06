package com.edu.engenharia.gestordesoftare.api.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edu.engenharia.gestordesoftare.api.dto.TarefaDTO;
import com.edu.engenharia.gestordesoftare.domain.entities.Tarefa;
import com.edu.engenharia.gestordesoftare.domain.services.TarefaService;

@RestController
@RequestMapping("api/tarefa")
public class TarefaController {
	@Autowired
	private TarefaService service;
	@Autowired
	private ModelMapper mapper;
	
	@PostMapping
	public ResponseEntity<TarefaDTO> post(@Valid @RequestBody TarefaDTO d) {
		Tarefa tarefa = service.create(mapper.map(d, Tarefa.class));
		if(tarefa!=null) {
			TarefaDTO dto = mapper.map(tarefa, TarefaDTO.class);
			return new ResponseEntity<>(dto,HttpStatus.OK);
		}
		else return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping("/{uuid}")
	public List<TarefaDTO> get(@PathVariable UUID uuid){
		List<TarefaDTO> lista = new ArrayList<TarefaDTO>();
		for(Tarefa d : service.searchByUuidDemanda(uuid)) {
			lista.add(mapper.map(d, TarefaDTO.class));
		}
		return lista;
	}
	
	@GetMapping
	public List<TarefaDTO> get(){
		List<TarefaDTO> lista = new ArrayList<TarefaDTO>();
		for(Tarefa d : service.searchAll()) {
			lista.add(mapper.map(d, TarefaDTO.class));
		}
		return lista;
	}
	
	@DeleteMapping("/{uuid}")
	public String delete(@PathVariable UUID uuid) {
		if(service.delete(uuid)) {
			return "Tarefa deletada";
		}
		else return "Tarefa não encontrada";
	}
	
}
