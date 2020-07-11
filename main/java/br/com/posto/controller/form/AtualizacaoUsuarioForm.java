package br.com.posto.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.posto.modelo.Usuario;
import br.com.posto.repository.UsuarioRepository;

public class AtualizacaoUsuarioForm {
	
	@NotNull @NotEmpty @Length(min = 10)
	private String nome;
	
	@NotNull @NotEmpty @Length(min = 6)
	private String senha;
	
	private String email;

	public String getNome() {
		return nome;
	}

	public String getSenha() {
		return senha;
	}

	public String getEmail() {
		return email;
	}

	public Usuario atualizar(Long id, UsuarioRepository usuaropRepository) {
		Usuario usuario = usuaropRepository.getOne(id);
		usuario.setNome(this.nome);
		usuario.setEmail(this.email);
		usuario.setSenha(this.senha);
		return usuario;
	}
	
}
