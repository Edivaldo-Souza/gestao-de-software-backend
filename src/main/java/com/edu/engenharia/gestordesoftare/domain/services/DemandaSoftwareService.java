package com.edu.engenharia.gestordesoftare.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.edu.engenharia.gestordesoftare.domain.entities.DemandaSoftware;
import com.edu.engenharia.gestordesoftare.domain.repository.DemandaRepository;

import java.util.List;
import java.util.UUID;

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
		//df.setUuidCliente(cliente);
		return repository.save(df);
	}
}
