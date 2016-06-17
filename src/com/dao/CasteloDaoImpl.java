package com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.entidade.Castelo;
import com.entidade.Entidade;

public class CasteloDaoImpl implements CasteloDao{

	protected EntityManager entityManager;
	
	public CasteloDaoImpl() {
		entityManager = getEntityManager();
	}
	
	private EntityManager getEntityManager(){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("PersistenceUnitFabio");
		if(entityManager == null){
			entityManager = factory.createEntityManager();
		}
		return entityManager;
	}
	
	@Override
	public Castelo consultar(Castelo princesa) { 
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void adicionar(Castelo castelo) {
		Long id = castelo.getId();
		id = id.equals(new Long(0)) ? null : id;
		castelo.setId(id);
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(castelo);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		}
		
	}

	@Override
	public Castelo consultarPorId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Castelo> listarTodas() {
		return entityManager.createQuery("FROM " + Castelo.class.getName()).getResultList();
	}

	@Override
	public void alterar(Castelo princesa) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void excluir(Castelo princesa) {
		// TODO Auto-generated method stub
		
	}

}
