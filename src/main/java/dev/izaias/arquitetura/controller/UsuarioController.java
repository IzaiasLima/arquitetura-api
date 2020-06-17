package dev.izaias.arquitetura.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.izaias.arquitetura.model.Usuario;
import dev.izaias.arquitetura.services.UsuarioService;

@RestController
public class UsuarioController {

	@Autowired
	UsuarioService service;

	@GetMapping("/usuarios")
	public List<Usuario> listarUsuarios() {


//		Usuario usuario = new Usuario();
//
//		usuario.setNome("Luciete Monteiro");
//		usuario.setEmail("luciete@dev");
//		usuario.setTelefone("931313393");
//		service.salvar(usuario);

		List<Usuario> lista = service.listarUsuarios();

		return lista;
	}

}
