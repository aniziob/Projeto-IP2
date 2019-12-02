package Main;

import Exceptions.MedicamentoNaoExisteException;
import Repositorio.RepositorioUsuario;

public class ControladorUsuario {

	private static ControladorUsuario instance;
	private RepositorioUsuario repositorioUsuarios;

	private ControladorUsuario() {
		this.repositorioUsuarios = new RepositorioUsuario();
	} 
	public static ControladorUsuario getInstance() throws MedicamentoNaoExisteException {
		if(instance == null) {
			instance = new ControladorUsuario();
		}
		return instance;
	}
}