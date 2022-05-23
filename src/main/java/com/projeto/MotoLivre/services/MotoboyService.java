package com.projeto.MotoLivre.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.projeto.MotoLivre.domain.Motoboy;
import com.projeto.MotoLivre.domain.Pessoa;
import com.projeto.MotoLivre.domain.dtos.MotoboyDTO;
import com.projeto.MotoLivre.repositories.MotoboyRepository;
import com.projeto.MotoLivre.repositories.PessoaRepository;
import com.projeto.MotoLivre.services.exceptions.DataIntegrityViolationException;
import com.projeto.MotoLivre.services.exceptions.ObjectnotFoundException;

@Service
public class MotoboyService {

	@Autowired
	private MotoboyRepository repository;
	@Autowired
	private PessoaRepository pessoaRepository;
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	public Motoboy findById(Integer id) {
		Optional<Motoboy> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectnotFoundException("Objeto não encontrado! id:"+ id));
	}

	public List<Motoboy> findAll() {
		return repository.findAll();
	}

	public Motoboy create(MotoboyDTO objDTO) {
		objDTO.setId(null);
		objDTO.setSenha(encoder.encode(objDTO.getSenha()));
		validaPorCpfEEmail(objDTO);
		Motoboy newObj = new Motoboy(objDTO);
		return repository.save(newObj);
	}
	public Motoboy update(Integer id, @Valid MotoboyDTO objDTO) {
		objDTO.setId(id);
		Motoboy oldObj = findById(id);
		validaPorCpfEEmail(objDTO);
		oldObj = new Motoboy(objDTO); 
		return repository.save(oldObj);
	}
	public void delete(Integer id) {
		Motoboy obj = findById(id);
		if(obj.getChamados().size() > 0) {
			throw new DataIntegrityViolationException("Motoboy possui ordens de serviço e não pode ser deletado!");
		}else {
			repository.deleteById(id);
		}
	}
	

	private void validaPorCpfEEmail(MotoboyDTO objDTO) {
		Optional<Pessoa> obj = pessoaRepository.findByCpfcnpj(objDTO.getCpfcnpj());
		if(obj.isPresent() && obj.get().getId() != objDTO.getId()) {
			throw new DataIntegrityViolationException("CPFCNPJ já cadastrado no sistema!");
		}
		obj = pessoaRepository.findByEmail(objDTO.getEmail());
		if(obj.isPresent() && obj.get().getId() != objDTO.getId()) {
			throw new DataIntegrityViolationException("E-mail já cadastrado no sistema!");
		}
	}

	

	

	
	
	
}
