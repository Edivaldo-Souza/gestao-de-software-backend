package com.edu.engenharia.gestordesoftare.api.controllers;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edu.engenharia.gestordesoftare.api.dto.CriarUsuarioDTO;
import com.edu.engenharia.gestordesoftare.api.dto.DemandaSoftwareDTO;
import com.edu.engenharia.gestordesoftare.api.dto.UsuarioDTO;
import com.edu.engenharia.gestordesoftare.domain.entities.DemandaSoftware;
import com.edu.engenharia.gestordesoftare.domain.entities.Usuario;
import com.edu.engenharia.gestordesoftare.domain.services.UsuarioService;

import javax.validation.Valid;

@RestController
@RequestMapping("api/usuario")
public class UsuarioController {
	@Autowired
	private ModelMapper mapper;
	@Autowired
	private UsuarioService service;
	
	@PostMapping
	public ResponseEntity<UsuarioDTO> post(@Valid @RequestBody CriarUsuarioDTO dto){
		Usuario usuario = service.create(mapper.map(dto, Usuario.class));
		if(usuario!=null) {
			UsuarioDTO res = mapper.map(usuario, UsuarioDTO.class);
			return new ResponseEntity<>(res,HttpStatus.OK);
		}
		else return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping("/{nome}")
	public ResponseEntity<UsuarioDTO> getByNome(@PathVariable String nome){
		UsuarioDTO u = mapper.map(service.searchByNome(nome),UsuarioDTO.class);
		if(u!=null) {
			return new ResponseEntity<>(u,HttpStatus.OK);
		}
		else return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
