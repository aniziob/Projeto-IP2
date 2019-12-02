package Repositorio;

import java.util.ArrayList;


import Exceptions.MedicamentoNaoExisteException;
import Main.Medicamento;

public class RepositorioMedicamento {
		
	public void Medicamento()  throws MedicamentoNaoExisteException {

	}
	

	public static  ArrayList <Medicamento> repMed = new ArrayList<>();
	

	public void addMedicamento(Medicamento medi) {
		repMed.add(medi);
	}
	
	public void removeMedicamento(Medicamento medi) {
		repMed.remove(medi);
	}
	

	//Verifca sem o produto existe no carrinho
	public static boolean Verificar(String produto){
		boolean achei=false;
		for(int i=0; i < RepositorioMedicamento.repMed.size(); i++) {
			if(RepositorioMedicamento.repMed.get(i).getNome().equals(produto)) {
				achei=true;
				break;
			}
		}
		return achei;
	}
	
	public static int VerificarPorNome(String produto){
		int achei=0;
		for(int i=0; i < RepositorioMedicamento.repMed.size(); i++) {
			if(RepositorioMedicamento.repMed.get(i).getNome().equals(produto)) {
				achei=RepositorioMedicamento.repMed.get(i).getId();
				break;
			}
		}
		return achei;
	}
	public static boolean buscar(int ID){
	        boolean achei=false;
	        
	        for(Medicamento u:repMed){
	            
	            if(u.getId()==(ID)){
	                achei=true;
	            }
	        }
	    	return achei; 
	}

	//Marcelo fazendo o método de procurar e retornar medicamento pra promocoes
	public static Medicamento buscaParaPromo(int id) {
	    for(Medicamento u:repMed){
               if(u.getId()==(id)){
               //O medicamento tem que receber promoAtiva == true
               return u;
               }
            }
	    return null;
	}
	//Vitor: buscando por nome e retornando o ID desse produto
	public static int buscar(String Nome){
        int achei=-1;
        for(int i=0; i < RepositorioMedicamento.repMed.size(); i++) {		
        	if(RepositorioMedicamento.repMed.get(i).getNome().equals(Nome)){
        		achei=RepositorioMedicamento.repMed.get(i).getId();//recebendo o ID do produto buscado
        	}
        }
        return achei; //retornado o ID do produto buscado
        }
	
	  public static int buscarAlterar(int ID){//
	        int achei=0;
	        for(int i=0;i<RepositorioMedicamento.repMed.size();i++) {
	        	  for(Medicamento u:repMed){
	  	            if(u.getId()==(ID)){
	  	                achei=RepositorioMedicamento.repMed.size();
	  	            }
	        	  }
	        }
	        return achei; 
	   }
		
}


