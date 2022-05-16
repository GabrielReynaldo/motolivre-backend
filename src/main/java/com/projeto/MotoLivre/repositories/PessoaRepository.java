package com.projeto.MotoLivre.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.MotoLivre.domain.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {

	Optional<Pessoa> findByCpfcnpj(String cpfcnpj);
	Optional<Pessoa> findByEmail(String email);
}
