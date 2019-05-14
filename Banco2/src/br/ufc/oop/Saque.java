package br.ufc.oop;

import br.ufc.oop.exception.ValorInvalidoException;

public class Saque extends Operacao {

	int numeroOrigem;
	public Saque(float valor, int numeroOrigem){
		super(valor);
		this.numeroOrigem = numeroOrigem;
	}
	
	
	public int getNumeroOrigem() {
		return numeroOrigem;
	}


	public void setNumeroOrigem(int numeroOrigem) {
		this.numeroOrigem = numeroOrigem;
	}


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String ops = super.toString();
		String s1 = "Saque ";
		ops = ops.substring(9, ops.length() -1);
		
		ops += ", numeroOrigem=" + numeroOrigem + "]";
		
		
		return "Saque " + ops;
		
	}

	
}
