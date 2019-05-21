package br.ufc.oop;

import br.ufc.oop.exception.SaqueSemSucessoException;

public class ContaPoupanca extends ContaBancaria implements Imprimivel {

	private double limite; 
	public ContaPoupanca(int numeroConta, double saldo, double limite) {
		super(numeroConta, saldo);
		this.limite = Math.abs(limite);
		
	}

	@Override
	public void sacar(double valor) throws SaqueSemSucessoException {
		double novoSaldo = saldo - valor;
		if(novoSaldo < -this.limite){
			throw new SaqueSemSucessoException();
		}else {
			this.saldo = novoSaldo;
		}

	}

	@Override
	public void depositar(double valor) {
		this.saldo += valor;

	}

	public double getLimite() {
		return limite;
	}

	public void setLimite(double limite) {
		this.limite = limite;
	}

	@Override
	public void mostrarDados() {
		StringBuilder sb = new StringBuilder();
		sb.append("ContaPoupanca =[");
		sb.append("saldo=").append(saldo).append(", ");
		sb.append("numeroConta=").append(numeroConta).append(", ");
		sb.append("limite=").append(limite);
		sb.append("]");
		System.out.println(sb.toString());
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		return true;
	}
	
	

}
