package br.ufc.oop;

public class PFisica extends Contribuinte {

	private String cpf;
	public PFisica(String nome, double rendaBruta, String cpf) {
		super(nome, rendaBruta);
		this.cpf = cpf;
	}

	@Override
	public double calcularImposto() {
		if(rendaBruta <= 1400){
			return 0;
		} else if(rendaBruta <= 2100){
			return 100 + rendaBruta * 0.1;
		} else if(rendaBruta <= 2800){
			return 270 + rendaBruta * 0.15;
		} else if(rendaBruta <= 3600){
			return 500 + rendaBruta * 0.25;
		} else {
			return 700 + rendaBruta * 0.3;
		}
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	

}
