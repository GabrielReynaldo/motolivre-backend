package com.projeto.MotoLivre.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.MotoLivre.domain.Estabelecimento;
import com.projeto.MotoLivre.domain.dtos.EstabelecimentoDTO;
import com.projeto.MotoLivre.services.EstabelecimentoService;




@RestController
@RequestMapping(value = "/estabelecimentos")
public class EstabelecimentoResource {
	// localhost:8080/estabelecimento/1
	
		@Autowired
		private EstabelecimentoService service;
		
		@GetMapping(value = "/{id}")
		public ResponseEntity<EstabelecimentoDTO> finById(@PathVariable Integer id){
			Estabelecimento obj = service.findById(id);
			return ResponseEntity.ok().body(new EstabelecimentoDTO(obj)); 
		}
		
		@GetMapping
		public ResponseEntity<List<EstabelecimentoDTO>> findAll() {
			 List<Estabelecimento> list = service.findAll();
			 List<EstabelecimentoDTO> listDTO = list.stream().map(obj -> new EstabelecimentoDTO(obj)).collect(Collectors.toList());
			 return ResponseEntity.ok().body(listDTO);
					 }
}
