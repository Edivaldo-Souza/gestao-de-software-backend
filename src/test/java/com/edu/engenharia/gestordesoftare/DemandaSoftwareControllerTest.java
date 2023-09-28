package com.edu.engenharia.gestordesoftare;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.junit.jupiter.api.Assertions;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.edu.engenharia.gestordesoftare.api.controllers.DemadaSoftwareController;
import com.edu.engenharia.gestordesoftare.api.dto.DemandaSoftwareDTO;
import com.edu.engenharia.gestordesoftare.domain.entities.DemandaSoftware;
import com.edu.engenharia.gestordesoftare.domain.services.DemandaSoftwareService;

@ExtendWith(MockitoExtension.class)
public class DemandaSoftwareControllerTest {

	@InjectMocks
	private DemadaSoftwareController controller;
	
	@Mock
	private ModelMapper mapper;
	@Mock
	private DemandaSoftwareService service;
	@Mock
	private DemandaSoftware demanda;
	
	private DemandaSoftwareDTO dto;
	
	@BeforeEach
	void definicao(){
		dto = new DemandaSoftwareDTO();
		dto.setDescricao("Exemplo de descricao para teste");
		dto.setTitulo("Sistema de Testes");
		demanda = new DemandaSoftware();
		demanda.setTitulo(dto.getTitulo());
		demanda.setDescricao(dto.getDescricao());
	}
	
	
	@Test
	void createDemanda() {
		Mockito.when(service.create(mapper.map(dto, DemandaSoftware.class))).thenReturn(demanda);
		ResponseEntity<DemandaSoftwareDTO> res = controller.post(dto);
		Assertions.assertEquals(ResponseEntity.status(HttpStatus.OK).build(),res);
	}
}
