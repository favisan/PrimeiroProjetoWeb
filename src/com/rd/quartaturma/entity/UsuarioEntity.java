package com.rd.quartaturma.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;


@Entity
@Table(name="TB_USUARIO")
@NamedQuery(name="Usuario.findAll", query="SELECT t FROM UsuarioEntity t")
public class UsuarioEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//SELECT * FROM TB_USUARIO t, TB_GENERO g WHERE t.ID_GENERO = g.ID_GENERO
	
	@Id
	@GeneratedValue
	@Column(name="ID_USUARIO")
	private BigInteger idUsuario;

	@JoinColumn(name = "ID_GENERO")
	private GeneroEntity genero;
	
	@Column(name="ID_ESP_MED")
	private BigInteger idEspMed;
	
	@Column(name="ID_UF_CRM")
	private BigInteger idUfCrm;
	
	@Column(name="ID_TIPO_USUARIO")
	private BigInteger idTipoUsuario;
	
	@Column(name="DS_NOME")
	private String nome;
	
	@Temporal(TemporalType.DATE)
	@Column(name="DT_NASCIMENTO")
	private Date dtNascimento;
	
	@Column(name="NR_CPF")
	private String cpf;
	
	public BigInteger getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(BigInteger idUsuario) {
		this.idUsuario = idUsuario;
	}

	public BigInteger getIdEspMed() {
		return idEspMed;
	}

	public void setIdEspMed(BigInteger idEspMed) {
		this.idEspMed = idEspMed;
	}

	public BigInteger getIdUfCrm() {
		return idUfCrm;
	}

	public void setIdUfCrm(BigInteger idUfCrm) {
		this.idUfCrm = idUfCrm;
	}

	public BigInteger getIdTipoUsuario() {
		return idTipoUsuario;
	}

	public void setIdTipoUsuario(BigInteger idTipoUsuario) {
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public UsuarioEntity() {
	}


	public GeneroEntity getGenero() {
		return genero;
	}

	public void setGenero(GeneroEntity genero) {
		this.genero = genero;
	}

}