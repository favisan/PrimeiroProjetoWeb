package com.rd.quartaturma.vo;

import java.util.Date;

public class Usuario {
	
	private Integer idUsuario;
	private Integer idGenero;
	private Integer idEspMed;
	private Integer idUfCrm;
	private Integer idTipoUsuario;
	private String nome;
	private Date dtNascimento;
	private String cpf;
	private String crm;
	private String endImagem;
	
	public Integer getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}
	public Integer getIdGenero() {
		return idGenero;
	}
	public void setIdGenero(Integer idGenero) {
		this.idGenero = idGenero;
	}
	public Integer getIdEspMed() {
		return idEspMed;
	}
	public void setIdEspMed(Integer idEspMed) {
		this.idEspMed = idEspMed;
	}
	public Integer getIdUfCrm() {
		return idUfCrm;
	}
	public void setIdUfCrm(Integer idUfCrm) {
		this.idUfCrm = idUfCrm;
	}
	public Integer getIdTipoUsuario() {
		return idTipoUsuario;
	}
	public void setIdTipoUsuario(Integer idTipoUsuario) {
		this.idTipoUsuario = idTipoUsuario;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getDtNascimento() {
		return dtNascimento;
	}
	public void setDtNascimento(Date dtNascimento) {
		this.dtNascimento = dtNascimento;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getCrm() {
		return crm;
	}
	public void setCrm(String crm) {
		this.crm = crm;
	}
	public String getEndImagem() {
		return endImagem;
	}
	public void setEndImagem(String endImagem) {
		this.endImagem = endImagem;
	}
	
}
