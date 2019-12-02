package Repositorio;

import java.util.ArrayList;

import Main.Compra;

public class RepositorioCompra {
	public static  ArrayList <Compra> compr = new ArrayList<>();
	
	private Compra compra = new Compra();
	
	public static void addCompra(Compra comp) {
		compr.add(comp);
	}


	
	
}
