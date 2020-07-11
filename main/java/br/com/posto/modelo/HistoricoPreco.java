package br.com.posto.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class HistoricoPreco {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Double preco;
	
	public HistoricoPreco () {
		
	}
	
	public HistoricoPreco(Double preco, Usuario usuarioId) {
		super();
		this.preco = preco;
		this.usuarioId = usuarioId;
	}

	@ManyToOne
	private Usuario usuarioId;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Usuario getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Usuario usuarioId) {
		this.usuarioId = usuarioId;
	}

}
