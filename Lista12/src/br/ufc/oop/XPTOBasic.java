package br.ufc.oop;

import br.ufc.oop.exception.SaldoInsuficienteException;

public class XPTOBasic extends XPTOConta {
	

	public XPTOBasic(int numeroConta) {
		super(numeroConta);
		
	}

	@Override
	public void creditar(double valor) {
		this.saldo += valor;

	}

	@Override
	public void debitar(double valor) throws SaldoInsuficienteException {
		if(this.saldo >= valor)
			this.saldo -= valor;
		else
			throw new SaldoInsuficienteException("Saldo insuficiente");
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "XPTOBasic: " + super.toString();
	}

}
