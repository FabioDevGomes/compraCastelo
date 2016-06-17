package com.manageBean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import com.dao.PrincesaDao;
import com.dao.PrincesaDaoImpl;
import com.entidade.Princesa;

@ManagedBean(name = "princesaMB")
public class PrincesaMB implements Serializable{
	private static final long serialVersionUID = 1L;
	private Princesa princesa;
	private List<Princesa> lista = new ArrayList<Princesa>();
	
	
	PrincesaDao dao = new PrincesaDaoImpl();

	public PrincesaMB() {
		setPrincesa(new Princesa());
		listar();
	}
	
	public void alterar(){
		dao.alterar(getPrincesa());
		listar();
		FacesContext.getCurrentInstance().addMessage(null, 
				new FacesMessage(FacesMessage.SEVERITY_INFO, 
				"Manutenção de Princesas:", 
				"Princesa alterada com sucesso!"));
	}
	
	
	public void incluir(){
		Princesa princesa = getPrincesa();
		dao.adicionar(princesa);
		listar(); 
		FacesContext.getCurrentInstance().addMessage(null, 
				new FacesMessage(FacesMessage.SEVERITY_INFO, 
						"Manutenção de princesa:", 
						"princesa incluída com sucesso!"));
	}
	
	public void consultar() {
		long matriculaConsulta = getPrincesa().getId();
		setPrincesa(dao.consultar(getPrincesa()));
		if (getPrincesa() == null || getPrincesa().getId() == 0) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Manutenção de usuário: ",
							"Usuario não encontrado matrícula:" + matriculaConsulta + "!"));
		}
		listar();
	}
	
	public void limpar(){
		setPrincesa(new Princesa());
	}
	
	public void excluir(){
		dao.excluir(getPrincesa());
		listar();
		FacesContext.getCurrentInstance().addMessage(null, 
				new FacesMessage(FacesMessage.SEVERITY_INFO, 
						"Exclusão:", 
						"princesa Excluída com sucesso!"));
	}
	
	//=================================================================
	
	public void listar(){
		lista = dao.listarTodas();
	}

	public Princesa getPrincesa() {
		return princesa;
	}

	public void setPrincesa(Princesa princesa) {
		this.princesa = princesa;
	}

	public List<Princesa> getLista() {
		return lista;
	}

	public void setLista(List<Princesa> lista) {
		this.lista = lista;
	}
}
