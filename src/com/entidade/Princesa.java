package com.entidade;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="princesa")
public class Princesa {
	@Id
	@GeneratedValue
	@Column(name="princesa_id")
	private Long id;
	private String nome;
	private Boolean amaFabio;
	private Integer idade;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinColumn(name="PRINCESA_ID")
	private List<Castelo> castelos;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Boolean getAmaFabio() {
		return amaFabio;
	}
	public void setAmaFabio(Boolean amaFabio) {
		this.amaFabio = amaFabio;
	}
	public Integer getIdade() {
		return idade;
	}
	public void setIdade(Integer idade) {
		this.idade = idade;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public List<Castelo> getCastelos() {
		return castelos;
	}
	public void setCastelos(List<Castelo> castelos) {
		this.castelos = castelos;
	}
}
