package com.edu.engenharia.gestordesoftare.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.edu.engenharia.gestordesoftare.domain.entities.Usuario;

@Service
public interface UsuarioRepository extends JpaRepository<Usuario,Long>{
	Usuario findByNome(String nome);
	List<Usuario> findByTipoUsuario(int tipoUsuario);
}
