package Repositorio;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import Main.Carrinho;


public class RepositorioCarrinho {

	public static  ArrayList <Carrinho> car = new ArrayList<>();
	
	public static void addNoCarrinho(Carrinho carrinho) {
		car.add(carrinho);
	}
	public void removeDoCarrinho(Carrinho carrinho) {
		car.remove(carrinho);
	}
	//vitor:Recebe uma String para retornar o ID do produto caso ele exista
	public static int Verificar(String produto){
		int achei=-1;
		for(int i=0; i < RepositorioCarrinho.car.size(); i++) {
			if(RepositorioCarrinho.car.get(i).getNome().equals(produto)) {
				achei=RepositorioCarrinho.car.get(i).getID();//Retornado o ID
				break;
			}
		}
		return achei;
	}


	//vitor:Vai me retornar um Boolean 
	public static boolean buscar(int ID){//
        boolean achei=false;
        
        for(Carrinho u:car){
            
            if(u.getID()==(ID)){
                achei=true;
            }
        }
        return achei; 
    }
	
	public static int buscarAlterar(int ID){//Vai me retornar a posição disponível no Array
    int achei=0;
    for(int i=0;i<RepositorioCarrinho.car.size();i++) {
    	for(Carrinho u:car){
    		if(u.getID()==(ID)){
    			achei=RepositorioCarrinho.car.size();
  	        }
    	}
    }
    return achei; 
	}
	//vai formartar um double e retornar uma string com apenas 2 casas decimais
	public static String format(double x) {
		return String.format("%.2f",x);
	}
	//Vai verificar se o ID existe no repositorio de produtos
	public static boolean buscarID(int ID) {
		boolean achei=false;
		for(int i =0; i<RepositorioMedicamento.repMed.size();i++) {
			if(RepositorioMedicamento.repMed.get(i).getId()== ID) {
				achei=true;
			}
		}
		return achei;
	}
	
}