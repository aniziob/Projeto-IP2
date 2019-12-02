package Repositorio;

import java.util.ArrayList;

import Main.AtualizarLista;


public class RepositorioAtualizarLista {
	public static  ArrayList <AtualizarLista> att = new ArrayList<>();
	
	public static void addNaLista(AtualizarLista Atualizar) {
		att.add(Atualizar);
	}

	public static ArrayList<AtualizarLista> getAtt() {
		return att;
	}

	public static void setAtt(ArrayList<AtualizarLista> att) {
		RepositorioAtualizarLista.att = att;
	}
	
}
