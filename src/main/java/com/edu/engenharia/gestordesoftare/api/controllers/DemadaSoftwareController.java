package com.edu.engenharia.gestordesoftare.api.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edu.engenharia.gestordesoftare.domain.services.DemandaSoftwareService;
import com.edu.engenharia.gestordesoftare.api.dto.AtualizarDemandaDTO;
import com.edu.engenharia.gestordesoftare.api.dto.CriarDemandaDTO;
import com.edu.engenharia.gestordesoftare.api.dto.DemandaSoftwareDTO;
import com.edu.engenharia.gestordesoftare.domain.entities.DemandaSoftware;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

@RestController
@RequestMapping("api/demanda")
public class DemadaSoftwareController {
	@Autowired
	private DemandaSoftwareService service;
	@Autowired
	private ModelMapper mapper;
	
	
	@PostMapping
	public ResponseEntity<DemandaSoftwareDTO> post(@Valid @RequestBody CriarDemandaDTO d) {
		DemandaSoftware demanda = service.create(mapper.map(d, DemandaSoftware.class));
		if(demanda!=null) {
			DemandaSoftwareDTO dto = mapper.map(demanda, DemandaSoftwareDTO.class);
			return new ResponseEntity<>(dto,HttpStatus.OK);
		}
		else return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@PutMapping
	public ResponseEntity<DemandaSoftwareDTO> put(@Valid @RequestBody AtualizarDemandaDTO d) {
		DemandaSoftware demanda = service.update(mapper.map(d, DemandaSoftware.class));
		if(demanda!=null) {
			DemandaSoftwareDTO dto = mapper.map(demanda, DemandaSoftwareDTO.class);
			return new ResponseEntity<>(dto,HttpStatus.OK);
		}
		else return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@PutMapping("/concluir")
	public ResponseEntity<DemandaSoftwareDTO> concluirProduto(@Valid @RequestBody AtualizarDemandaDTO d) {
		DemandaSoftware demanda = service.encerrarDemanda(mapper.map(d, DemandaSoftware.class));
		if(demanda!=null) {
			DemandaSoftwareDTO dto = mapper.map(demanda, DemandaSoftwareDTO.class);
			return new ResponseEntity<>(dto,HttpStatus.OK);
		}
		else return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping
	public List<DemandaSoftwareDTO> getDemandasCliente(){
		List<DemandaSoftwareDTO> lista = new ArrayList<DemandaSoftwareDTO>();
		for(DemandaSoftware d : service.searchForAll()) {
			lista.add(mapper.map(d, DemandaSoftwareDTO.class));
		}
		return lista;
	}
	
	@GetMapping("/emAnalise")
	public List<DemandaSoftwareDTO> getDemandasClienteEmAnalise(){
		List<DemandaSoftwareDTO> lista = new ArrayList<DemandaSoftwareDTO>();
		for(DemandaSoftware d : service.searchBySituacao(0)) {
			lista.add(mapper.map(d, DemandaSoftwareDTO.class));
		}
		return lista;
	}
	
	@GetMapping("/cliente/{uuid}")
	public List<DemandaSoftwareDTO> getDemandasCliente(@PathVariable UUID uuid){
		List<DemandaSoftwareDTO> lista = new ArrayList<DemandaSoftwareDTO>();
		for(DemandaSoftware d : service.searchByUuidCliente(uuid)) {
			lista.add(mapper.map(d, DemandaSoftwareDTO.class));
		}
		return lista;
	}
	
	@GetMapping("/dev/{uuid}")
	public List<DemandaSoftwareDTO> getDemandasDevs(@PathVariable UUID uuid){
		List<DemandaSoftwareDTO> lista = new ArrayList<DemandaSoftwareDTO>();
		for(DemandaSoftware d : service.searchByUuidDev(uuid)) {
			lista.add(mapper.map(d, DemandaSoftwareDTO.class));
		}
		return lista;
	}
	
	@DeleteMapping("/{uuid}")
	public String delete(@PathVariable UUID uuid) {
		if(service.delete(uuid)) {
			return "Demanda deletada";
		}
		else return "Demanda não encontrada";
	}
	
}
