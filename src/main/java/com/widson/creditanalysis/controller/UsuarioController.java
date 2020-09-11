package com.widson.creditanalysis.controller;

import java.util.ArrayList;
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
import com.widson.creditanalysis.model.Usuario;
import com.widson.creditanalysis.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@GetMapping("/all")
	public List<Usuario> readAll() {
		
		return usuarioRepository.findAll();	
	}
	
	// Faz a busca, se houver algum registro, retorna ele, caso contrário retorna o código 404 (não encontrado)
	@GetMapping("/{usuarioId}")
	public ResponseEntity<Usuario> readById(@PathVariable Long usuarioId) {
		Optional<Usuario> usuario = usuarioRepository.findById(usuarioId);
		if(usuario.isPresent()) {
			return ResponseEntity.ok(usuario.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	// Transforma o json recebido no corpo em um objeto Usuario e cria no banco de dados
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario create(@Valid @RequestBody Usuario usuario) {
//		Endereco endereco = new Endereco();
//		endereco.setRua(usuario.getEndereco().getRua());
//		endereco.setComplemento(usuario.getEndereco().getComplemento());
//		endereco.setNumero(usuario.getEndereco().getNumero());
//		endereco.setCep(usuario.getEndereco().getCep());
//		endereco.setCidade(usuario.getEndereco().getCidade());
//		endereco.setEstado(usuario.getEndereco().getEstado());
//		endereco.setPais(usuario.getEndereco().getPais());
//		EnderecoController ce = new EnderecoController();
//		usuario.setEndereco(ce.create(endereco));		
		return usuarioRepository.save(usuario);
	}
	
	// Faz a busca, se o elemento existir, atualiza, caso contrrário retorna 404
	// @Valid valida as regrasdos campos para ficar igual as definições do model (@size)
	@PutMapping("/{usuarioId}")
	public ResponseEntity<Usuario> updateById(@Valid @PathVariable Long usuarioId, @RequestBody Usuario usuario) {
		if (usuarioRepository.existsById(usuarioId)) {
			usuario.setId(usuarioId);
			usuario = usuarioRepository.save(usuario);
			return ResponseEntity.ok().body(usuario);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/{usuarioId}")
	public ResponseEntity<Void> delete(@PathVariable Long usuarioId){
		if (usuarioRepository.existsById(usuarioId)) {
			usuarioRepository.deleteById(usuarioId);
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}
