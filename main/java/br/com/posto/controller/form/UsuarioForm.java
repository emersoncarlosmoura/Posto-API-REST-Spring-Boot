package br.com.posto.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.posto.modelo.Usuario;

public class UsuarioForm {

	@NotNull @NotEmpty @Length(min = 10)
	private String nome;
	
	@NotNull @NotEmpty @Length(min = 6)
	private String senha;
	
	private String email;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Usuario converter() {
		return new Usuario(nome, email, senha);
	}

}
