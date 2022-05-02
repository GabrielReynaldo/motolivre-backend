package com.projeto.MotoLivre.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.projeto.MotoLivre.domain.enums.Prioridade;
import com.projeto.MotoLivre.domain.enums.Status;

@Entity
public class Chamado implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataAbertuda = LocalDate.now();
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataFechamento;
	
	private Prioridade prioridade;
	private Status status;
	private String titulo;
	private String observacoes;
	
	@ManyToOne
	@JoinColumn(name = "motoboy_id")
	private Motoboy motoboy;
	
	@ManyToOne
	@JoinColumn(name = "estabelecimento_id")
	private Estabelecimento estabelecimento;
	
	public Chamado() {
		super();
	}
	public Chamado(Integer id, Prioridade prioridade, Status status, String titulo, String observacoes, Motoboy motoboy,
			Estabelecimento estabelecimento) {
		super();
		this.id = id;
		this.prioridade = prioridade;
		this.status = status;
		this.titulo = titulo;
		this.observacoes = observacoes;
		this.motoboy = motoboy;
		this.estabelecimento = estabelecimento;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public LocalDate getDataAbertuda() {
		return dataAbertuda;
	}
	public void setDataAbertuda(LocalDate dataAbertuda) {
		this.dataAbertuda = dataAbertuda;
	}
	public LocalDate getDataFechamento() {
		return dataFechamento;
	}
	public void setDataFechamento(LocalDate dataFechamento) {
		this.dataFechamento = dataFechamento;
	}
	public Prioridade getPrioridade() {
		return prioridade;
	}
	public void setPrioridade(Prioridade prioridade) {
		this.prioridade = prioridade;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getObservacoes() {
		return observacoes;
	}
	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}
	public Motoboy getMotoboy() {
		return motoboy;
	}
	public void setMotoboy(Motoboy motoboy) {
		this.motoboy = motoboy;
	}
	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}
	public void setEstabelecimento(Estabelecimento estabelecimento) {
		this.estabelecimento = estabelecimento;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Chamado other = (Chamado) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
