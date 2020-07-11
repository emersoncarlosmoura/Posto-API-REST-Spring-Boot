package br.com.posto.controller;

import java.net.URI;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.posto.controller.dto.HistoricoPrecoDto;
import br.com.posto.controller.form.AtualizacaoHistoricoPrecoForm;
import br.com.posto.controller.form.HistoricoPrecoForm;
import br.com.posto.modelo.HistoricoPreco;
import br.com.posto.repository.HistoricoPrecoRepository;
import br.com.posto.repository.UsuarioRepository;

@RestController
@RequestMapping("/historicos")
public class HistoricoPrecoController {
	
	@Autowired
	private HistoricoPrecoRepository historicoPrecoRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@GetMapping("/{id}")
	public ResponseEntity<HistoricoPrecoDto> buscar (@PathVariable Long id) {
		Optional<HistoricoPreco> historicoPreco = historicoPrecoRepository.findById(id);
		if (historicoPreco.isPresent()) {
			return ResponseEntity.ok(new HistoricoPrecoDto(historicoPreco.get()));
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<HistoricoPrecoDto> cadastrar(@RequestBody @Valid HistoricoPrecoForm form, UriComponentsBuilder uriBuilder) {
		HistoricoPreco historicoPreco = form.converter(usuarioRepository);
		if (historicoPreco.getUsuarioId() == null) {
			return ResponseEntity.badRequest().build();
		} else{
			historicoPrecoRepository.save(historicoPreco);
			URI uri = uriBuilder.path("/historicos/{id}").buildAndExpand(historicoPreco.getId()).toUri();
			return ResponseEntity.created(uri).body(new HistoricoPrecoDto(historicoPreco));
		}
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<HistoricoPrecoDto> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizacaoHistoricoPrecoForm form) {
		Optional<HistoricoPreco> optional = historicoPrecoRepository.findById(id);
		if (optional.isPresent()) {
			HistoricoPreco historicoPreco = form.atualizar(id, historicoPrecoRepository, usuarioRepository);
			if (historicoPreco == null) {
				return ResponseEntity.badRequest().build();
			}
			else {
				return ResponseEntity.ok(new HistoricoPrecoDto(historicoPreco));
			}
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id) {
		Optional<HistoricoPreco> optional = historicoPrecoRepository.findById(id);
		if (optional.isPresent()) {
			historicoPrecoRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}

}
