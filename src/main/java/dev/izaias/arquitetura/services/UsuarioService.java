package dev.izaias.arquitetura.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.izaias.arquitetura.model.Usuario;
import dev.izaias.arquitetura.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	UsuarioRepository repository;
	
	public List<Usuario> listarUsuarios(){
		return repository.findAll();
		
	}

	public void salvar(Usuario usuario) {
		repository.save(usuario);
	}

}
