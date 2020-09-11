package com.widson.creditanalysis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.widson.creditanalysis.model.Candidato;
import com.widson.creditanalysis.model.Endereco;

@Repository
public interface CandidatoRepository extends JpaRepository<Candidato, Long>{
	List<Candidato> findByNome (String nome);
}
