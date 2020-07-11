package br.com.posto.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.posto.modelo.HistoricoPreco;

public class HistoricoPrecoDto {

	private Long id;
	private Double preco;
	private Long usuario;
	
	public HistoricoPrecoDto(HistoricoPreco historicoPreco) {
		this.id = historicoPreco.getId();
		this.preco = historicoPreco.getPreco();
		this.usuario = historicoPreco.getUsuarioId().getId();
	}

	public Long getId() {
		return id;
	}

	public Double getPreco() {
		return preco;
	}

	public Long getUsuario() {
		return usuario;
	}

	public static List<HistoricoPrecoDto> converter(List<HistoricoPreco> historicoPrecos) {
		return historicoPrecos.stream().map(HistoricoPrecoDto::new).collect(Collectors.toList());
	}

}
