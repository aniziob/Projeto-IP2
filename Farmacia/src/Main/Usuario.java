package Main;
//@author Anizio Barbosa
public class Usuario {
	 private String cpf;	
	 private String nome;
	 private int Idade;
	 private int index1;
	 
		public int getIndex() {
		return index1;
	}


	public void setIndex(int index) {
		this.index1 = index;
	}


		public int getIdade() {
		return Idade;
	}


	public void setIdade(int idade) {
		Idade = idade;
	}


		public Usuario(String cpf, String nome, int Idade) {
			this.cpf = cpf;
			this.nome = nome;
			this.Idade = Idade;

		}
		
	
		public Usuario() {
			// TODO Auto-generated constructor stub
		}
		


		public String getCpf() {
			return cpf;
		}
		public void setCpf(String cpf) {
			this.cpf = cpf;
		}
		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}

}