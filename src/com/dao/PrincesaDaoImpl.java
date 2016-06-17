package com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.entidade.Princesa;

public class PrincesaDaoImpl implements PrincesaDao{
	protected EntityManager entityManager;
	
	public PrincesaDaoImpl() {
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
	public Princesa consultar(Princesa princesa) {
		return entityManager.find(Princesa.class, princesa.getId());
	}

	@Override
	public void adicionar(Princesa princesa) {
//		princesa.setId(princesa.getId().equals(new Long(0)) ? null : princesa.getId());
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(princesa);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	@Override
	public Princesa consultarPorId(final Long id) {
		return entityManager.find(Princesa.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Princesa> listarTodas() {
		return entityManager.createQuery("FROM " + Princesa.class.getName()).getResultList();
	}

	@Override
	public void alterar(Princesa princesa) {
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(princesa);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	@Override
	public void excluir(Princesa princesa) {
		try {
			entityManager.getTransaction().begin();
			princesa = entityManager.find(Princesa.class, princesa.getId());
			entityManager.remove(princesa);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		}
		
	}

}
