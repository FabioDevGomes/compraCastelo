package com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.entidade.CompraCastelo;

public class CasteloCompraDaoImpl implements CasteloCompraDAO{

protected EntityManager entityManager;
	
	public CasteloCompraDaoImpl() {
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
	public void comprar(CompraCastelo compraCastelo) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(compraCastelo);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		}
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CompraCastelo> listar() {
		return entityManager.createQuery(" FROM "+ CompraCastelo.class.getName()).getResultList();
		
	}

}
