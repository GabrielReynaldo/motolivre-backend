package com.projeto.MotoLivre.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.MotoLivre.domain.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {

}
