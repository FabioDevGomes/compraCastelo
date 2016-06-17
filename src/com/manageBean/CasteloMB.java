package com.manageBean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import com.dao.CasteloDao;
import com.dao.CasteloDaoImpl;
import com.entidade.Castelo;
import com.entidade.Entidade;
import com.entidade.Princesa;


@ManagedBean(name = "casteloMB")
public class CasteloMB implements Serializable {
	private static final long serialVersionUID = 1L;
	private Castelo castelo;
	private List<Castelo> listaCastelos = new ArrayList<Castelo>();
	private CasteloDao dao = new CasteloDaoImpl();
	
	public CasteloMB() {
		setCastelo(new Castelo());
		listar();
	}
	
	public void incluir(){
		Castelo castelo = getCastelo();
		dao.adicionar(castelo);
		listar(); 
		FacesContext.getCurrentInstance().addMessage(null, 
				new FacesMessage(FacesMessage.SEVERITY_INFO, 
						"Manutençao de princesa:", 
						"Castelo incluído com sucesso!"));
	}
	
	public Castelo getCastelo() {
		return castelo;
	}
	public void setCastelo(Castelo castelo) {
		this.castelo = castelo;
	}
	public List<Castelo> getListaCastelos() {
		return listaCastelos;
	}
	public void setListaCastelos(List<Castelo> listaCastelos) {
		this.listaCastelos = listaCastelos;
	}
	
	public void listar(){
		listaCastelos = dao.listarTodas();
	}
	
}
