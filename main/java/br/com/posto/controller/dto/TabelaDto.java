package br.com.posto.controller.dto;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import br.com.posto.modelo.Tabela;

public class TabelaDto {

	private Long id;
	
	private String regiao;
	
	private String estadoSigla;
	
	private String municipio;
	
	private String revenda;
	
	private String cnpj;
	
	private String produto;
	
	private Date dataColeta;
	
	private Double valorVenda;
	
	private Double valorCompra;
	
	private String unidadeMedida;
	
	private String bandeira;
	
	public TabelaDto(Tabela tabela) {
		this.id = tabela.getId();
		this.regiao = tabela.getRegiao();
		this.estadoSigla = tabela.getEstadoSigla();
		this.municipio = tabela.getMunicipio();
		this.revenda = tabela.getRevenda();
		this.cnpj = tabela.getCnpj();
		this.produto = tabela.getProduto();
		this.dataColeta = tabela.getDataColeta();
		this.valorVenda = tabela.getValorVenda();
		this.valorCompra = tabela.getValorCompra();
		this.unidadeMedida = tabela.getUnidadeMedida();
		this.bandeira = tabela.getBandeira();
	}

	public Long getId() {
		return id;
	}

	public String getRegiao() {
		return regiao;
	}

	public String getEstadoSigla() {
		return estadoSigla;
	}

	public String getMunicipio() {
		return municipio;
	}

	public String getRevenda() {
		return revenda;
	}

	public String getCnpj() {
		return cnpj;
	}

	public String getProduto() {
		return produto;
	}

	public Date getDataColeta() {
		return dataColeta;
	}

	public Double getValorVenda() {
		return valorVenda;
	}

	public Double getValorCompra() {
		return valorCompra;
	}

	public String getUnidadeMedida() {
		return unidadeMedida;
	}

	public String getBandeira() {
		return bandeira;
	}
	
	public static List<TabelaDto> converter(List<Tabela> tabelas) {
		return tabelas.stream().map(TabelaDto::new).collect(Collectors.toList());
	}
	
}
