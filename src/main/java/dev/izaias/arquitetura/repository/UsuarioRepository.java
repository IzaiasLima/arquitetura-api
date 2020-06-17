package dev.izaias.arquitetura.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.izaias.arquitetura.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
