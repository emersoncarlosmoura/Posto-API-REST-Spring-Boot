package br.com.posto.controller;

import java.io.IOException;
import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.posto.service.TabelaService;

@RestController
@RequestMapping("/tabela")
public class TabelaController {
	
	@Autowired
	private TabelaService tabelaService;
	
	@GetMapping("/importar")
	public ResponseEntity<?> buscar () throws IOException, ParseException {
		 tabelaService.importarCsv();
		 return ResponseEntity.ok().build();
	}
	
}
