package com.main;

import com.dao.PrincesaDao;
import com.dao.PrincesaDaoImpl;
import com.entidade.Princesa;

public class TestarJPA {
	
	public static void main(String[] args) {
		Princesa princesa = new Princesa();
		princesa.setNome("Pricesa Gabi");
		princesa.setAmaFabio(true);
		princesa.setIdade(19);
		
		Princesa princesa2 = new Princesa();
		princesa2.setNome("Princesa Jasmine");
		princesa2.setAmaFabio(false);
		princesa2.setIdade(20);
		
		PrincesaDao dao = new PrincesaDaoImpl();
		dao.adicionar(princesa);
		dao.adicionar(princesa2);
		
		for (Princesa p : dao.listarTodas()) {
			System.out.println("/////////////");
			System.out.println(p.getNome() +", idade: "+p.getIdade()+", é especial: "+p.getAmaFabio());
			System.out.println("/////////////");
		}
	}

}
