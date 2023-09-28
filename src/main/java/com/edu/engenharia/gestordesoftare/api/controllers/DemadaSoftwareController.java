package com.edu.engenharia.gestordesoftare.api.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edu.engenharia.gestordesoftare.domain.services.DemandaSoftwareService;
import com.edu.engenharia.gestordesoftare.api.dto.CriarDemandaDTO;
import com.edu.engenharia.gestordesoftare.api.dto.DemandaSoftwareDTO;
import com.edu.engenharia.gestordesoftare.domain.entities.DemandaSoftware;
import java.util.List;

import javax.validation.Valid;

@RestController
@RequestMapping("api/demanda")
public class DemadaSoftwareController {
	@Autowired
	private DemandaSoftwareService service;
	@Autowired
	private ModelMapper mapper;
	
	@GetMapping
	public List<DemandaSoftware> getAll(){
		return null;
	}
	
	@PostMapping
	public ResponseEntity<DemandaSoftwareDTO> post(@Valid @RequestBody CriarDemandaDTO d) {
		DemandaSoftware demanda = service.create(mapper.map(d, DemandaSoftware.class));
		if(demanda!=null) {
			DemandaSoftwareDTO dto = mapper.map(demanda, DemandaSoftwareDTO.class);
			return new ResponseEntity<>(dto,HttpStatus.OK);
		}
		else return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	
}
