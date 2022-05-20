package com.projeto.MotoLivre.domain.dtos;

import java.io.Serializable;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.projeto.MotoLivre.domain.Chamado;

public class ChamadoDTO  implements Serializable{
	private static final long serialVersionUID = 1L;

private Integer id;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataAbertuda = LocalDate.now();
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataFechamento;
	private Integer prioridade;
	private Integer status;
	private String titulo;
	private String observacoes;
	private Integer motoboy;
	private Integer estabelecimento;
	private String nomeEstabelecimento;
	private String nomeMotoboy;
	public ChamadoDTO() {
		super();
	}
	
	public ChamadoDTO( Chamado obj) {
		this.id = obj.getId();
		this.dataAbertuda = obj.getDataAbertuda();
		this.dataFechamento = obj.getDataFechamento();
		this.prioridade = obj.getPrioridade().getCodigo();
		this.status = obj.getStatus().getCodigo();
		this.titulo = obj.getTitulo();
		this.observacoes = obj.getObservacoes();
		this.motoboy = obj.getMotoboy().getId();
		this.estabelecimento = obj.getEstabelecimento().getId();
		this.nomeEstabelecimento = obj.getEstabelecimento().getNome();
		this.nomeMotoboy = obj.getMotoboy().getNome();
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

	public Integer getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(Integer prioridade) {
		this.prioridade = prioridade;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
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

	public Integer getMotoboy() {
		return motoboy;
	}

	public void setMotoboy(Integer motoboy) {
		this.motoboy = motoboy;
	}

	public Integer getEstabelecimento() {
		return estabelecimento;
	}

	public void setEstabelecimento(Integer estabelecimento) {
		this.estabelecimento = estabelecimento;
	}

	public String getNomeEstabelecimento() {
		return nomeEstabelecimento;
	}

	public void setNomeEstabelecimento(String nomeEstabelecimento) {
		this.nomeEstabelecimento = nomeEstabelecimento;
	}

	public String getNomeMotoboy() {
		return nomeMotoboy;
	}

	public void setNomeMotoboy(String nomeMotoboy) {
		this.nomeMotoboy = nomeMotoboy;
	}
	
	
}
