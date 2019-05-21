package br.ufc.oop;

import br.ufc.oop.exception.DepositoSemSucessoException;
import br.ufc.oop.exception.SaqueSemSucessoException;

public abstract class ContaBancaria implements Imprimivel{
	protected int numeroConta;
	protected double saldo;
	
	public abstract void sacar(double valor) throws SaqueSemSucessoException;
	public abstract void depositar(double valor) throws DepositoSemSucessoException;
	public void transferir(double valor, ContaBancaria favorecido){
		double estorno = this.saldo;
		try {
			this.sacar(valor);
			favorecido.depositar(valor);
		} catch (SaqueSemSucessoException e) {
			System.err.println("Saque sem sucesso");
			this.saldo = estorno;
		} catch (DepositoSemSucessoException e) {
			System.err.println("Deposito sem sucesso");
			this.saldo = estorno;
		}
		
		
	}
	
	
	public ContaBancaria(int numeroConta, double saldo) {
		
		this.numeroConta = numeroConta;
		this.saldo = saldo;
	}
	public int getNumeroConta() {
		return numeroConta;
	}
	public void setNumeroConta(int numeroConta) {
		this.numeroConta = numeroConta;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContaBancaria other = (ContaBancaria) obj;
		if (numeroConta != other.numeroConta)
			return false;
		return true;
	}
	
	
	

}
