package com.projeto.MotoLivre.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.MotoLivre.domain.Chamado;

public interface ChamadoRepository extends JpaRepository<Chamado, Integer> {

}
