package br.ufc.oop;

import br.ufc.oop.exception.SaqueSemSucessoException;

public abstract class ContaBancaria {
	protected int numeroConta;
	protected double saldo;
	
	public abstract void sacar(double valor) throws SaqueSemSucessoException;
	public abstract void depositar(double valor);
	public void transferir(double valor, ContaBancaria favorecido){
		double estorno = this.saldo;
		try {
			this.sacar(valor);
		} catch (SaqueSemSucessoException e) {
			// TODO Auto-generated catch block
			System.err.println("Saque sem sucesso..");
		}
		favorecido.depositar(valor);
		
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
	
	
	

}
