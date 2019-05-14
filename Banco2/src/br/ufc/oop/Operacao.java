package br.ufc.oop;

import br.ufc.oop.exception.ValorInvalidoException;

public class Operacao {
	
	private float valor;
	
	
	
	
	public Operacao(float valor){
		if(valor <= 0)
			throw new ValorInvalidoException("Valor informado deve ser maior que zero");
		this.valor = valor;
		
	}





	public float getValor() {
		return valor;
	}




	public void setValor(float valor) {
		this.valor = valor;
	}





	@Override
	public String toString() {
		return "Operacao [valor=" + valor + "]";
	}
	
	
}
