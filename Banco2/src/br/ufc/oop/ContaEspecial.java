package br.ufc.oop;

public class ContaEspecial extends Conta {
	private float limiteExtra;
	public ContaEspecial(int numero, float saldo, float limiteExtra) {
		super(numero, saldo);
		this.limiteExtra = limiteExtra;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void saque(Saque op) {
		// TODO Auto-generated method stub
		try{
			super.saque(op);
			limiteExtra += op.getValor();
		} catch(Exception e){
			
		}
	}

}
