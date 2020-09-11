package com.widson.creditanalysis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.widson.creditanalysis.model.Proposta;
import com.widson.creditanalysis.model.Usuario;

public interface PropostaRepository extends JpaRepository<Proposta, Long>{
	List<Usuario> findByStatus (String nome);
}
