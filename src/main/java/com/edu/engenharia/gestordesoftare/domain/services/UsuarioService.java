package com.edu.engenharia.gestordesoftare.domain.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.edu.engenharia.gestordesoftare.domain.entities.Usuario;
import com.edu.engenharia.gestordesoftare.domain.repository.UsuarioRepository;

@Service
public class UsuarioService {
	@Autowired
	UsuarioRepository repository;
	
	public Usuario create(Usuario u) {
		String senhaEncriptada = BCrypt.hashpw(u.getSenha(), BCrypt.gensalt(8));
		u.setSenha(senhaEncriptada);
		u.setUuid(UUID.randomUUID());
		return repository.save(u);
	}
	
	public Usuario searchByNome(String nome) {
		return repository.findByNome(nome);
	}
	
	public List<Usuario> searchByTipo(int tipo){
		return repository.findByTipoUsuario(tipo);
	}
}
