package com.widson.creditanalysis.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.widson.creditanalysis.model.Endereco;
import com.widson.creditanalysis.repository.EnderecoRepository;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@GetMapping("/all")
	public List<Endereco> readAll() {
		return enderecoRepository.findAll();	
	}
	
	// Faz a busca, se houver algum registro, retorna ele, caso contrário retorna o código 404 (não encontrado)
	@GetMapping("/{enderecoId}")
	public ResponseEntity<Endereco> readById(@PathVariable Long enderecoId) {
		Optional<Endereco> endereco = enderecoRepository.findById(enderecoId);
		if(endereco.isPresent()) {
			return ResponseEntity.ok(endereco.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	
	
	// Transforma o json recebido no corpo em um objeto Car e cria no banco de dados
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Endereco create(@Valid @RequestBody Endereco endereco) {
		return enderecoRepository.save(endereco);
	}
	
	// Faz a busca, se o elemento existir, atualiza, caso contrrário retorna 404
	// @Valid valida as regrasdos campos para ficar igual as definições do model (@size)
	@PutMapping("/{enderecoId}")
	public ResponseEntity<Endereco> updateById(@Valid @PathVariable Long enderecoId, @RequestBody Endereco endereco) {
		if (enderecoRepository.existsById(enderecoId)) {
			endereco.setId(enderecoId);
			endereco = enderecoRepository.save(endereco);
			return ResponseEntity.ok().body(endereco);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
//	@RequestMapping("/{enderecoId}")
	@DeleteMapping("/{enderecoId}")
	public ResponseEntity<Void> delete(@PathVariable Long enderecoId){
		if (enderecoRepository.existsById(enderecoId)) {
			enderecoRepository.deleteById(enderecoId);
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
