package com.entidade;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "compra_castelo")
public class CompraCastelo {
	
	@Id
	@GeneratedValue
	@Column(name="compra_castelo_id")
	private Long id;
	
	@OneToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.EAGER, orphanRemoval = true)
	private Princesa princesaCompradora;
	
	@OneToOne
	private Castelo casteloComprado;
	
	@Column(name="MONEY", precision=5, scale=2)
	private BigDecimal valor;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Princesa getPrincesaCompradora() {
		return princesaCompradora;
	}
	public void setPrincesaCompradora(Princesa princesaCompradora) {
		this.princesaCompradora = princesaCompradora;
	}
	public Castelo getCasteloComprado() {
		return casteloComprado;
	}
	public void setCasteloComprado(Castelo casteloComprado) {
		this.casteloComprado = casteloComprado;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

}
