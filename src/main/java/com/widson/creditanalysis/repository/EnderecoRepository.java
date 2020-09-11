package com.widson.creditanalysis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.widson.creditanalysis.model.Endereco;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long>{
	List<Endereco> findByRua (String rua);
	List<Endereco> findByCep (String cep);
//	List<Endereco> findById (Long id);
}