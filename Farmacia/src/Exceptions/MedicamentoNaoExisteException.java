package Exceptions;

import Main.Medicamento;

public class MedicamentoNaoExisteException extends Exception {
	   private Medicamento m;

	    public MedicamentoNaoExisteException(Medicamento m) {
	        super("Medicamento Não se encontra em nosso repositorio.");
	        this.m = m;
	    }

	    public Medicamento getNome() {
	        return m;
	    }

	    public void setConta(Medicamento m) {
	        this.m = m;
	    }

}


