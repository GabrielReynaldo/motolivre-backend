package com.projeto.MotoLivre.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.projeto.MotoLivre.domain.dtos.MotoboyDTO;
import com.projeto.MotoLivre.domain.enums.Perfil;

@Entity
public class Motoboy extends Pessoa{
	private static final long serialVersionUID = 1L;
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "motoboy")
	private List<Chamado> chamados = new ArrayList<>(); 
	
	public Motoboy() {
		super();
		addPerfil(Perfil.MOTOBOY);
	}

	public Motoboy(Integer id, String nome, String cpfcnpj, String email, String senha) {
		super(id, nome, cpfcnpj, email, senha);
		addPerfil(Perfil.MOTOBOY);
	}
	public Motoboy(MotoboyDTO obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.cpfcnpj = obj.getCpfcnpj();
		this.email = obj.getEmail();
		this.senha = obj.getSenha();
		this.perfis = obj.getPerfis().stream().map(x -> x.getCodigo()).collect(Collectors.toSet());
		this.dataCriacao = obj.getDataCriacao();
	}

	public List<Chamado> getChamados() {
		return chamados;
	}

	public void setChamados(List<Chamado> chamados) {
		this.chamados = chamados;
	}

}
