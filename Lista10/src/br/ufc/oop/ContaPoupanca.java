package br.ufc.oop;

public class ContaPoupanca extends ContaBancaria implements Imprimivel {

	private double limite; 
	public ContaPoupanca(int numeroConta, double saldo, double limite) {
		super(numeroConta, saldo);
		this.limite = Math.abs(limite);
		
	}

	@Override
	public void sacar(double valor) {
		double novoSaldo = saldo - valor;
		if(novoSaldo < -this.limite){
			//erro
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
	
	

}
