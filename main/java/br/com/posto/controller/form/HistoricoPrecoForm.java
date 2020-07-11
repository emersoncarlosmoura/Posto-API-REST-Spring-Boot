package br.com.posto.controller.form;

import javax.validation.constraints.NotNull;

import br.com.posto.modelo.HistoricoPreco;
import br.com.posto.modelo.Usuario;
import br.com.posto.repository.UsuarioRepository;

public class HistoricoPrecoForm {

	@NotNull
	private Double preco;
	
	@NotNull
	private Long idUsuario;
	
	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public HistoricoPreco converter(UsuarioRepository repository) {
		if (repository.existsById(idUsuario)) {
			Usuario usuario = repository.getOne(idUsuario);
			return new HistoricoPreco(preco, usuario);
		} else {
			return new HistoricoPreco(preco, null);
		}
	}

}
