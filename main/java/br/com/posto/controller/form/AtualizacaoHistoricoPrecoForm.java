package br.com.posto.controller.form;

import javax.validation.constraints.NotNull;

import br.com.posto.modelo.HistoricoPreco;
import br.com.posto.modelo.Usuario;
import br.com.posto.repository.HistoricoPrecoRepository;
import br.com.posto.repository.UsuarioRepository;

public class AtualizacaoHistoricoPrecoForm {
	
	@NotNull
	private Double preco;
	
	@NotNull
	private Long idUsuario;

	public Double getPreco() {
		return preco;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public HistoricoPreco atualizar(Long id, HistoricoPrecoRepository repository, UsuarioRepository usuarioRepository) {
		if (usuarioRepository.existsById(idUsuario)) {
			HistoricoPreco historico = repository.getOne(id);
			Usuario usuario = usuarioRepository.getOne(idUsuario);
			historico.setPreco(this.preco);
			historico.setUsuarioId(usuario);
			return historico;
		} else {
			return null;
		}
	}
	
}
