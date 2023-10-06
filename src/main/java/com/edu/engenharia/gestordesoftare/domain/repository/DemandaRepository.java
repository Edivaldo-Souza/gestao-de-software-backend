package com.edu.engenharia.gestordesoftare.domain.repository;

import com.edu.engenharia.gestordesoftare.domain.entities.DemandaSoftware;

import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DemandaRepository extends JpaRepository<DemandaSoftware,Long>{
	DemandaSoftware findByUuid(UUID uuid);
	List<DemandaSoftware> findBySituacao(int situacao);
	List<DemandaSoftware> findByUuidCliente(UUID uuid);
	List<DemandaSoftware> findByUuidDev(UUID uuid);
}
