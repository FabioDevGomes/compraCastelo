package com.dao;

import java.util.List;

import com.entidade.Princesa;

public interface PrincesaDao {
	public Princesa consultar(Princesa princesa);
	public void adicionar(Princesa princesa);
	public Princesa consultarPorId(final Long id);
	public List<Princesa> listarTodas();
	public void alterar(Princesa princesa);
	public void excluir(Princesa princesa);
}
