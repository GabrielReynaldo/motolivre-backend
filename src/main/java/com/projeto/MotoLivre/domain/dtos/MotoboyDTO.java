package com.projeto.MotoLivre.domain.dtos;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.projeto.MotoLivre.domain.Motoboy;
import com.projeto.MotoLivre.domain.enums.Perfil;

public class MotoboyDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	protected Integer id;
	@NotNull(message = "O campo nome destacado é requirido")
	protected String nome;
	@NotNull(message = "O campo CpfCnpj destacado é requirido")
	protected String cpfcnpj;
	@NotNull(message = "O campo Email destacado é requirido")
	protected String email;
	@NotNull(message = "O campo Senha destacado é requirido")
	protected String senha;
	
	protected Set<Integer> perfis = new HashSet<>();
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	protected LocalDate dataCriacao = LocalDate.now();

	public MotoboyDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MotoboyDTO(Motoboy obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.cpfcnpj = obj.getCpfcnpj();
		this.email = obj.getEmail();
		this.senha = obj.getSenha();
		this.perfis = obj.getPerfis().stream().map(x -> x.getCodigo()).collect(Collectors.toSet());
		this.dataCriacao = obj.getDataCriacao();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpfcnpj() {
		return cpfcnpj;
	}

	public void setCpfcnpj(String cpfcnpj) {
		this.cpfcnpj = cpfcnpj;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Set<Perfil> getPerfis() {
		return perfis.stream().map(x ->Perfil.toEnum(x)).collect(Collectors.toSet());
	}

	public void addPerfis(Perfil perfil) {
		this.perfis.add(perfil.getCodigo());
	}

	public LocalDate getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDate dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	
	
	
}
