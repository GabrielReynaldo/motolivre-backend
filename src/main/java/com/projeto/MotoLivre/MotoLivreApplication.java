package com.projeto.MotoLivre;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.projeto.MotoLivre.domain.Chamado;
import com.projeto.MotoLivre.domain.Estabelecimento;
import com.projeto.MotoLivre.domain.Motoboy;
import com.projeto.MotoLivre.domain.enums.Perfil;
import com.projeto.MotoLivre.domain.enums.Prioridade;
import com.projeto.MotoLivre.domain.enums.Status;
import com.projeto.MotoLivre.repositories.ChamadoRepository;
import com.projeto.MotoLivre.repositories.EstabelecimentoRepository;
import com.projeto.MotoLivre.repositories.MotoboyRepository;




@SpringBootApplication
public class MotoLivreApplication implements CommandLineRunner {

	@Autowired
	private ChamadoRepository chamadoRepository;
	@Autowired
	private EstabelecimentoRepository estabelecimentoRepository;
	@Autowired
	private MotoboyRepository motoboyRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(MotoLivreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Estabelecimento est1 = new Estabelecimento(null, "Gabriel Henrique", "26252386073", "gabriel@gmail.com", "123");
		est1.addPerfil(Perfil.ADMIN);
		
		Motoboy mot1 = new Motoboy(null, "Paulo Silva", "21708714030", "paulo@gmail.com", "123");
		
		Chamado c1 = new Chamado(null,Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 01", "Primeiro chamado", mot1, est1);
		
		estabelecimentoRepository.saveAll(Arrays.asList(est1));
		motoboyRepository.saveAll(Arrays.asList(mot1));
		chamadoRepository.saveAll(Arrays.asList(c1));
		
	
	}

}
