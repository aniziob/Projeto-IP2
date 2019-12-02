package Repositorio;

import java.time.LocalDate;
import java.util.ArrayList;

import Main.Medicamento;
import Main.Promocao;

public class RepositorioPromocao {
	public static  ArrayList <Promocao> repPromo = new ArrayList<>();
	
	public void addPromocao (Promocao promo) {
		repPromo.add(promo);
	}
	public void removePromocao(Promocao promo) {
		repPromo.remove(promo);
	}
	
	public static void aplicarDesconto(int id) {
		double desconto = 0;
		Medicamento achei = RepositorioMedicamento.buscaParaPromo(id);
		if(achei != null) {
			for(Promocao u:repPromo){
	            if(u.getIdProduto()==(id)){
	                desconto = u.getValorDesconto();
	            }
	        }
			achei.setPreço(achei.getPreço() - (achei.getPreço() * desconto));
		}
	}
	//Aplica o desconto e salva o preço anterior
	public static void desconto(int id, float desconto) {
		double prev = RepositorioMedicamento.repMed.get(id).getPreço();
		RepositorioMedicamento.repMed.get(id).setValorInterior(RepositorioMedicamento.repMed.get(id).getPreço());
		RepositorioMedicamento.repMed.get(id).setPreço
		(RepositorioMedicamento.repMed.get(id).getPreço()-(prev *(desconto/100)));
		RepositorioMedicamento.repMed.get(id).setPromo("  P: "+desconto+"%");
	}
	//Remove o valor promocional e retorna o valor antigo no atual
	public static void removerPromocao(int id) {
		RepositorioMedicamento.repMed.get(id).setPreço(RepositorioMedicamento.repMed.get(id).getValorInterior());
		RepositorioMedicamento.repMed.get(id).setPromo("");
	}
	
	public boolean verificaVigencia(int id) {
		LocalDate dataInicio, dataFim, hoje = LocalDate.now();
		for(Promocao u:repPromo){
            if(u.getIdProduto()==(id)){
            	dataInicio = u.getDataInicio();
            	dataFim = u.getDataFim();
            	
            	if (dataInicio.isBefore(hoje) && dataFim.isAfter(hoje)) {
            		//Ta dentro da vigencia
        			return true;
        		}else if(dataInicio.equals(hoje) || dataFim.equals(hoje)) {
        			//É igual a uma das datas, então ta dentro da vigência
        			return true;
        		}else {
        			//Não ta dentro da vigência
        			return false;
        		}
                
            }
        }
		return false;
	}

}
