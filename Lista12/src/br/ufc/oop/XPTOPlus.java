package br.ufc.oop;

import br.ufc.oop.exception.SaldoInsuficienteException;

public class XPTOPlus extends XPTOConta {

	private static final double CREDITO_BONUS = 0.005d;
	public XPTOPlus(int numeroConta) {
		super(numeroConta);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void creditar(double valor) {
		this.saldo += valor + (valor * CREDITO_BONUS);

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
		return "XPTOPlus: " + super.toString();
	}

}
