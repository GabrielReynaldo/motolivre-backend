package com.projeto.MotoLivre.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.MotoLivre.domain.Chamado;
import com.projeto.MotoLivre.domain.Estabelecimento;
import com.projeto.MotoLivre.domain.Motoboy;
import com.projeto.MotoLivre.domain.dtos.ChamadoDTO;
import com.projeto.MotoLivre.domain.enums.Prioridade;
import com.projeto.MotoLivre.domain.enums.Status;
import com.projeto.MotoLivre.repositories.ChamadoRepository;
import com.projeto.MotoLivre.services.exceptions.ObjectnotFoundException;

@Service
public class ChamadoService {

	@Autowired
	private ChamadoRepository repository;
	@Autowired
	private EstabelecimentoService estabelecimentoservice;
	@Autowired
	private MotoboyService motoboyservice;
	
	public Chamado findById(Integer id) {
		Optional<Chamado> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectnotFoundException("Objeto não encontrado ID" + id));
	}

	public List<Chamado> findAll() {
		return repository.findAll();
	}

	public Chamado create(@Valid ChamadoDTO objDTO) {
		return repository.save(newChamado(objDTO));
	}
	
	private Chamado newChamado(ChamadoDTO obj) {
		Estabelecimento estabelecimento = estabelecimentoservice.findById(obj.getEstabelecimento());
		Motoboy motoboy = motoboyservice.findById(obj.getMotoboy());
		
		Chamado chamado = new Chamado();
		if(obj.getId() != null) {
			chamado.setId(obj.getId());
		}
		chamado.setEstabelecimento(estabelecimento);
		chamado.setMotoboy(motoboy);
		chamado.setPrioridade(Prioridade.toEnum(obj.getPrioridade()));
		chamado.setStatus(Status.toEnum(obj.getStatus()));
		chamado.setTitulo(obj.getTitulo());
		chamado.setObservacoes(obj.getObservacoes());
		return chamado;
		
		
	}
}
