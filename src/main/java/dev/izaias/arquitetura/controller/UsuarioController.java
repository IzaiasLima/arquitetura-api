package dev.izaias.arquitetura.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dev.izaias.arquitetura.model.Usuario;
import dev.izaias.arquitetura.repository.UsuarioRepository;
import dev.izaias.arquitetura.services.UsuarioService;

@RestController
public class UsuarioController {

	@Autowired
	UsuarioService service;
	
	@Autowired
	UsuarioRepository repository;

	@GetMapping("/usuarios")
	public List<Usuario> listarUsuarios() {
		return service.listarUsuarios();
	}

	@GetMapping("usuarios/{id}")
	public Usuario getUsuario(@PathVariable Long id) {
		return service.getUsuario(id);

	}

	@PutMapping("usuarios/{id}")
	Usuario salvar(@RequestBody Usuario usr, @PathVariable Long id) {

		return repository.findById(id).map(usuario -> {
			usuario.setNome(usr.getNome());
			usuario.setEmail(usr.getEmail());
			usuario.setTelefone(usr.getTelefone());
			return repository.save(usuario);
		}).orElseGet(() -> {
			return cadastrar(usr);
		});
	}
	

	@PostMapping("usuarios")
	Usuario cadastrar(@RequestBody Usuario usr) {
			return repository.save(usr);
	}

}
