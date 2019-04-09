package br.ufc;

public class Estrela {

	public Estrela(){
		
	}
	
	public String ranqueiaQuarto(Quarto quarto) throws QuartoNuloException{
		if(quarto == null){
			throw new QuartoNuloException("Valor do quarto nao pode ser nulo");
		}
		return new String("" + quarto.getPreco() % 5);
	}
}
