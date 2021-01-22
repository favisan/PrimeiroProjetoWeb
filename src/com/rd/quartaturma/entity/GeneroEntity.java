package com.rd.quartaturma.entity;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "TB_GENERO")
public class GeneroEntity {

	@Id
	@GeneratedValue
	@Column(name = "ID_GENERO")
	private BigInteger idGenero;
	
	@Column(name = "DS_GENERO")
	private String dsGenero;

	public BigInteger getIdGenero() {
		return idGenero;
	}

	public void setIdGenero(BigInteger idGenero) {
		this.idGenero = idGenero;
	}

	public String getDsGenero() {
		return dsGenero;
	}

	public void setDsGenero(String dsGenero) {
		this.dsGenero = dsGenero;
	}
	
	
	
}
