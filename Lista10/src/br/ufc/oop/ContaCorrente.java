package br.ufc.oop;

public class ContaCorrente extends ContaBancaria implements Imprimivel{

	private double taxaDeOperacao;
	public ContaCorrente(int numeroConta, double saldo, double taxaDeOperacao) {
		super(numeroConta, saldo);
		this.taxaDeOperacao = taxaDeOperacao;
	}

	@Override
	public void sacar(double valor) {
		double novoSaldo = saldo - valor - taxaDeOperacao;
		if(saldo >= valor + taxaDeOperacao)
			saldo -= valor + taxaDeOperacao;

	}

	@Override
	public void depositar(double valor) {
		if(saldo + valor >= taxaDeOperacao)
			saldo += valor - taxaDeOperacao;
		
		

	}

	public double getTaxaDeOperacao() {
		return taxaDeOperacao;
	}

	public void setTaxaDeOperacao(double taxaDeOperacao) {
		this.taxaDeOperacao = taxaDeOperacao;
	}

	@Override
	public void mostrarDados() {
		StringBuilder sb = new StringBuilder();
		sb.append("ContaCorrente =[");
		sb.append("saldo=").append(saldo).append(", ");
		sb.append("numeroConta=").append(numeroConta).append(", ");
		sb.append("taxaDeOperacao=").append(taxaDeOperacao);
		sb.append("]");
		System.out.println(sb.toString());
		
	}
	

}
