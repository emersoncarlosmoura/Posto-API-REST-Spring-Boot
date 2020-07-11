package br.com.posto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.posto.modelo.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	List<Usuario> findByNome(String nomeUsuario);

}
