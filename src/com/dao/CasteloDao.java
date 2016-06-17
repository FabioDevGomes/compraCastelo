package com.dao;

import java.util.List;

import com.entidade.Castelo;
import com.entidade.Entidade;


public interface CasteloDao extends Dao{
	public Entidade consultar(Castelo castelo);
	public void adicionar(Castelo castelo);
	public Castelo consultarPorId(final Long id);
	public List<Castelo> listarTodas();
	public void alterar(Castelo castelo);
	public void excluir(Castelo castelo);
}
