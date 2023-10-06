package com.edu.engenharia.gestordesoftare.domain.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edu.engenharia.gestordesoftare.domain.entities.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa,Long>{
	Tarefa findByUuid(UUID uuid);
	List<Tarefa> findByUuidDemanda(UUID uuid);
}
