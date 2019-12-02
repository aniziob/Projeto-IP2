package Exceptions;

import Main.Medicamento;
import Main.Usuario;

public class UsuarioNaoExisteException extends Exception {
	 private Usuario u;

	    public UsuarioNaoExisteException(Usuario pessoa) {
	        super("Usuario Não se encontra em nosso repositorio.");
	        this.u = u;
	    }

	    public Usuario getNome() {
	        return u;
	    }

	    public void setConta(Usuario u) {
	        this.u = u;
	    }

}
