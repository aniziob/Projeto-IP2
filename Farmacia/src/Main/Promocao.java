package Main;

import java.time.LocalDate;

public class Promocao {
	private int idProduto;
	private float valorDesconto;
	private LocalDate dataInicio, dataFim;
	
	public Promocao(int idProduto, float valorDesconto, LocalDate dataInicio,
			LocalDate dataFim){
		this.idProduto = idProduto;
		this.valorDesconto = valorDesconto;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
	}
	public Promocao() {
		
	}

	public LocalDate getDataInicio() {
		return dataInicio;
	}


	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}


	public LocalDate getDataFim() {
		return dataFim;
	}


	public void setDataFim(LocalDate dataFim) {
		this.dataFim = dataFim;
	}

	public int getIdProduto() {
		return idProduto;
	}
	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}
	public float getValorDesconto() {
		return valorDesconto;
	}
	public void setValorDesconto(float valorDesconto) {
		this.valorDesconto = valorDesconto;
	}          
	
	
}
