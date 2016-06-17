package com.manageBean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import com.dao.CasteloCompraDAO;
import com.dao.CasteloCompraDaoImpl;
import com.dao.CasteloDao;
import com.dao.CasteloDaoImpl;
import com.entidade.Castelo;
import com.entidade.CompraCastelo;

@ManagedBean(name = "casteloCompraMB")
public class CasteloCompraMB implements Serializable {
	private static final long serialVersionUID = 1L;
	private CompraCastelo compraCastelo;
	private CasteloCompraDAO dao = new CasteloCompraDaoImpl();
	private CasteloDao daoCastelo = new CasteloDaoImpl();
	private List<CompraCastelo> listaCompras = new ArrayList<CompraCastelo>();
	private List<Castelo> castelos = new ArrayList<Castelo>();
	private Castelo castelo = new Castelo();
	
	public CasteloCompraMB() {
		setCompraCastelo(new CompraCastelo());
		listar();
	}

	private void listar(){
		setListaCompras(dao.listar());
		castelos = daoCastelo.listarTodas();
	}
	
	public void comprar(){
		dao.comprar(getCompraCastelo());
		listar();
		FacesContext.getCurrentInstance().addMessage(null, 
				new FacesMessage(FacesMessage.SEVERITY_INFO, 
				"Notificação de compra", 
				"Compra do castelo efetuada com sucesso"));
	}
	
	
	public CompraCastelo getCompraCastelo() {
		return compraCastelo;
	}

	public void setCompraCastelo(CompraCastelo compraCastelo) {
		this.compraCastelo = compraCastelo;
	}

	public List<CompraCastelo> getListaCompras() {
		return listaCompras;
	}

	public void setListaCompras(List<CompraCastelo> listaCompras) {
		this.listaCompras = listaCompras;
	}

	public List<Castelo> getCastelos() {
		return castelos;
	}

	public void setCastelos(List<Castelo> castelos) {
		this.castelos = castelos;
	}

	public Castelo getCastelo() {
		return castelo;
	}

	public void setCastelo(Castelo castelo) {
		this.castelo = castelo;
	}
	

}
