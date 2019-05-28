package br.ufc.oop;

import br.ufc.oop.exception.SaldoInsuficienteException;

public abstract class XPTOConta {

	protected int numeroConta;
	protected double saldo;
	public XPTOConta(int numeroConta) {
		this.numeroConta = numeroConta;
	}
	
	public abstract void creditar(double valor);
	public abstract void debitar(double valor) throws SaldoInsuficienteException;
	
	public double consultarSaldo(){
		return saldo;
	}
	
	@Override
	public String toString() {
		return "numeroConta=" + numeroConta + ", saldo=" + saldo;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof XPTOConta){
			XPTOConta other = (XPTOConta) obj;
			return other.numeroConta == this.numeroConta;
		}
		return false;
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
