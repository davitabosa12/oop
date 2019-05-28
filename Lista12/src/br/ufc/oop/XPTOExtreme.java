package br.ufc.oop;

import br.ufc.oop.exception.SaldoInsuficienteException;

public class XPTOExtreme extends XPTOConta {

	private static final double CREDITO_BONUS = 0.002d;
	private static final double DEBITO_BONUS = 0.002d;
	
	public XPTOExtreme(int numeroConta) {
		super(numeroConta);
		
	}

	@Override
	public void creditar(double valor) {
		this.saldo += valor + (valor * CREDITO_BONUS);

	}

	@Override
	public void debitar(double valor) throws SaldoInsuficienteException {
		if(this.saldo >= valor - (valor * DEBITO_BONUS))
			this.saldo -= valor - (valor * DEBITO_BONUS);
		else
			throw new SaldoInsuficienteException("Saldo insuficiente");

	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "XPTOExtreme: " + super.toString();
	}

}
