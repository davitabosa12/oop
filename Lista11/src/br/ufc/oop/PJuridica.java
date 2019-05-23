package br.ufc.oop;

public class PJuridica extends Contribuinte {

	private String cnpj;
	public PJuridica(String nome, double rendaBruta, String cnpj) {
		super(nome, rendaBruta);
		this.cnpj = cnpj;
	}

	@Override
	public double calcularImposto() {
		return this.rendaBruta * 0.1;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

}
