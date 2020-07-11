package br.com.posto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.posto.modelo.Tabela;

public interface TabelaRepository extends JpaRepository<Tabela, Long> {
	
}
