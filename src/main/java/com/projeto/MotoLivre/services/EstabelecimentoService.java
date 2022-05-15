package com.projeto.MotoLivre.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.MotoLivre.domain.Estabelecimento;
import com.projeto.MotoLivre.repositories.EstabelecimentoRepository;

@Service
public class EstabelecimentoService {

	@Autowired
	private EstabelecimentoRepository repository;
	
	public Estabelecimento findById(Integer id) {
		Optional<Estabelecimento> obj = repository.findById(id);
		return obj.orElse(null);
	}
}
