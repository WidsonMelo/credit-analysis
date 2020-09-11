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
import com.widson.creditanalysis.model.Candidato;
import com.widson.creditanalysis.repository.CandidatoRepository;

@RestController
@RequestMapping("/candidato")
public class CandidatoController {
	@Autowired
	private CandidatoRepository candidatoRepository;
	
	// Faz uma busca por todos os registros de Candidado
	@GetMapping("/all")
	public List<Candidato> readAll() {
		return candidatoRepository.findAll();	
	}
	
	// Faz a busca pelo Id do Candidato, se houver algum registro, retorna ele, caso contrário retorna o código 404 (não encontrado)
	@GetMapping("/{candidatoId}")
	public ResponseEntity<Candidato> readById(@PathVariable Long candidatoId) {
		Optional<Candidato> candidato = candidatoRepository.findById(candidatoId);
		if(candidato.isPresent()) {
			return ResponseEntity.ok(candidato.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	// Faz uma busca pelo Candidato de acordo pelo atributo nome.
	@GetMapping("/nome")
	public List<Candidato> readByNome(@Valid @RequestBody Candidato candidato) {
		return candidatoRepository.findByNome(candidato.getNome());
	}
	
	// Transforma o json recebido no corpo em um objeto Candidato e cria no banco de dados
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Candidato create(@Valid @RequestBody Candidato candidato) {
		return candidatoRepository.save(candidato);
	}
	
	// Atualiza o Candidato de acordo com o JSON obtido
	@PutMapping("/{candidatoId}")
	public ResponseEntity<Candidato> updateById(@Valid @PathVariable Long candidatoId, @RequestBody Candidato candidato) {
		if (candidatoRepository.existsById(candidatoId)) {
			candidato.setId(candidatoId);
			candidato = candidatoRepository.save(candidato);
			return ResponseEntity.ok().body(candidato);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	// Deleta o registro de Candidato de acordo com o Id
	@DeleteMapping("/{candidatoId}")
	public ResponseEntity<Void> delete(@PathVariable Long candidatoId){
		if (candidatoRepository.existsById(candidatoId)) {
			candidatoRepository.deleteById(candidatoId);
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}
