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
import com.widson.creditanalysis.model.Proposta;
import com.widson.creditanalysis.repository.CandidatoRepository;
import com.widson.creditanalysis.repository.PropostaRepository;
import com.widson.creditanalysis.repository.UsuarioRepository;

@RestController
@RequestMapping("/proposta")
public class PropostaController {
	@Autowired
	private PropostaRepository propostaRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private CandidatoRepository candidatoRepository;
	
	@GetMapping("/all")
	public List<Proposta> readAll() {
		return propostaRepository.findAll();	
	}
	
	// Faz a busca, se houver algum registro, retorna ele, caso contrário retorna o código 404 (não encontrado)
	@GetMapping("/{propostaId}")
	public ResponseEntity<Proposta> readById(@PathVariable Long propostaId) {
		Optional<Proposta> proposta = propostaRepository.findById(propostaId);
		if(proposta.isPresent()) {
			return ResponseEntity.ok(proposta.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	// Transforma o json recebido no corpo em um objeto Car e cria no banco de dados
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Proposta create(@Valid @RequestBody Proposta proposta) {
		if (usuarioRepository.existsById(proposta.getCandidato().getId()) &&
			candidatoRepository.existsById(proposta.getCandidato().getId()) &&
			propostaRepository.existsById(proposta.getId()) &&
			proposta.getUsuario().getFuncao().contains("Captador")){
				return propostaRepository.save(proposta);
		} else {
			return null;
		}
	}
	
	// Faz a busca, se o elemento existir, atualiza, caso contrrário retorna 404
	// @Valid valida as regrasdos campos para ficar igual as definições do model (@size)
	@PutMapping("/{propostaId}")
	public ResponseEntity<Proposta> updateById(@Valid @PathVariable Long propostaId, @RequestBody Proposta proposta) {
		if (propostaRepository.existsById(propostaId)) {
			proposta.setId(propostaId);
			proposta = propostaRepository.save(proposta);
			return ResponseEntity.ok().body(proposta);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	// Faz a busca, se o elemento existir, atualiza, caso contrrário retorna 404
	// @Valid valida as regrasdos campos para ficar igual as definições do model (@size)
	@PutMapping("aprovar/{propostaId}")
	public ResponseEntity<Proposta> aprovarProposta(@Valid @PathVariable Long propostaId, @RequestBody Proposta proposta) {
		if (propostaRepository.existsById(propostaId) &&
				(proposta.getUsuario().getFuncao().equals("Analista")) &&
				(proposta.getStatus().contains("Pendente"))) {
			proposta.setId(propostaId);
			proposta.setStatus("Aprovado");
			proposta = propostaRepository.save(proposta);
			return ResponseEntity.ok().body(proposta);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	// Faz a busca, se o elemento existir, atualiza, caso contrrário retorna 404
	// @Valid valida as regrasdos campos para ficar igual as definições do model (@size)
	@PutMapping("reprovar/{propostaId}")
	public ResponseEntity<Proposta> reprovarProposta(@Valid @PathVariable Long propostaId, @RequestBody Proposta proposta) {
		if (propostaRepository.existsById(propostaId) &&
				(proposta.getUsuario().getFuncao().equals("Analista")) &&
				(proposta.getStatus().contains("Pendente"))) {
			proposta.setId(propostaId);
			proposta.setStatus("Reprovado");
			proposta = propostaRepository.save(proposta);
			return ResponseEntity.ok().body(proposta);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/{propostaId}")
	public ResponseEntity<Void> delete(@PathVariable Long propostaId){
		if (propostaRepository.existsById(propostaId)) {
			propostaRepository.deleteById(propostaId);
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}
