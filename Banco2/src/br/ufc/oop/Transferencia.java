package br.ufc.oop;

import br.ufc.oop.exception.ValorInvalidoException;

public class Transferencia extends Operacao {

	private int numeroOrigem, numeroDestino;
	public Transferencia(float valor, int numeroOrigem, int numeroDestino){
		super(valor);
		this.numeroOrigem = numeroOrigem;
		this.numeroDestino = numeroDestino;
	}
	public int getNumeroOrigem() {
		return numeroOrigem;
	}
	public void setNumeroOrigem(int numeroOrigem) {
		this.numeroOrigem = numeroOrigem;
	}
	public int getNumeroDestino() {
		return numeroDestino;
	}
	public void setNumeroDestino(int numeroDestino) {
		this.numeroDestino = numeroDestino;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String ops = super.toString();
		ops = ops.substring(9, ops.length() -1);
		ops += ", numeroOrigem = " + numeroOrigem + "]";
		
		return "Transferencia " + ops;
	}

}
