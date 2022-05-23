package com.projeto.MotoLivre.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.projeto.MotoLivre.domain.Chamado;
import com.projeto.MotoLivre.domain.Estabelecimento;
import com.projeto.MotoLivre.domain.Motoboy;
import com.projeto.MotoLivre.domain.enums.Perfil;
import com.projeto.MotoLivre.domain.enums.Prioridade;
import com.projeto.MotoLivre.domain.enums.Status;
import com.projeto.MotoLivre.repositories.ChamadoRepository;
import com.projeto.MotoLivre.repositories.EstabelecimentoRepository;
import com.projeto.MotoLivre.repositories.MotoboyRepository;

@Service

public class DBServices {
	
	@Autowired
	private ChamadoRepository chamadoRepository;
	@Autowired
	private EstabelecimentoRepository estabelecimentoRepository;
	@Autowired
	private MotoboyRepository motoboyRepository;
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	public void instanciaBD() {
		
		
		
		Estabelecimento est1 = new Estabelecimento(null, "Gabriel Henrique", "26252386073", "gabriel@gmail.com", encoder.encode("123"));

		
		est1.addPerfil(Perfil.ADMIN);
		
		Motoboy mot1 = new Motoboy(null, "Paulo Silva", "21708714030", "paulo@gmail.com", encoder.encode("123"));
		
		Chamado c1 = new Chamado(null,Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 01", "Primeiro chamado", mot1, est1);
		
		estabelecimentoRepository.saveAll(Arrays.asList(est1));
		motoboyRepository.saveAll(Arrays.asList(mot1));
		chamadoRepository.saveAll(Arrays.asList(c1));
	}

}
