package com.projeto.MotoLivre.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.projeto.MotoLivre.domain.enums.Perfil;

@Entity
public class Motoboy extends Pessoa{
	private static final long serialVersionUID = 1L;
	
	@OneToMany(mappedBy = "motoboy")
	private List<Chamado> chamados = new ArrayList<>(); 
	
	public Motoboy() {
		super();
		addPerfil(Perfil.MOTOBOY);
	}

	public Motoboy(Integer id, String nome, String cpfcnpj, String email, String senha) {
		super(id, nome, cpfcnpj, email, senha);
	}

	public List<Chamado> getChamados() {
		return chamados;
	}

	public void setChamados(List<Chamado> chamados) {
		this.chamados = chamados;
	}

}
