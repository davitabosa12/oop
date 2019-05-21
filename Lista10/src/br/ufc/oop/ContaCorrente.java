package br.ufc.oop;

import br.ufc.oop.exception.DepositoSemSucessoException;
import br.ufc.oop.exception.SaqueSemSucessoException;

public class ContaCorrente extends ContaBancaria implements Imprimivel{

	private double taxaDeOperacao;
	public ContaCorrente(int numeroConta, double saldo, double taxaDeOperacao) {
		super(numeroConta, saldo);
		this.taxaDeOperacao = taxaDeOperacao;
	}

	@Override
	public void sacar(double valor) throws SaqueSemSucessoException{
		double novoSaldo = saldo - valor - taxaDeOperacao;
		if(saldo >= valor + taxaDeOperacao)
			saldo -= valor + taxaDeOperacao;
		else
			throw new SaqueSemSucessoException("Valor maior que o saldo");

	}

	@Override
	public void depositar(double valor) throws DepositoSemSucessoException {
		if(saldo + valor >= taxaDeOperacao)
			saldo += valor - taxaDeOperacao;
		else
			throw new DepositoSemSucessoException();
		
		

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
