package com.dao;

import java.util.List;

import com.entidade.CompraCastelo;

public interface CasteloCompraDAO {

	public void comprar(CompraCastelo compraCastelo);
	public List<CompraCastelo> listar();
}
