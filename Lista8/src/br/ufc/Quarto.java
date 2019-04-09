package br.ufc;

public class Quarto {
	private int numero;
	private int andar;
	private boolean disponibilidade;
	private float preco;
	private int numReservas;
	
	public Quarto(int numero, int andar, float preco){
		this.numero = numero;
		this.andar = andar;
		this.preco = preco;
		this.disponibilidade = true;
	}
	
	
	public int getNumero() {
		return numero;
	}


	public void setNumero(int numero) {
		this.numero = numero;
	}


	public int getAndar() {
		return andar;
	}


	public void setAndar(int andar) {
		this.andar = andar;
	}



	public boolean isDisponibilidade() {
		return disponibilidade;
	}


	public void setDisponibilidade(boolean disponibilidade) {
		this.disponibilidade = disponibilidade;
	}


	public float getPreco() {
		return preco;
	}


	public void setPreco(float preco) {
		this.preco = preco;
	}


	public int getNumReservas() {
		return numReservas;
	}


	public void setNumReservas(int numReservas) {
		this.numReservas = numReservas;
	}


	public void reservaQuarto(){
		if(!isDisponibilidade())
			return;
		
		int val = getNumReservas();
		val++;
		setNumReservas(val);
		setDisponibilidade(false);
		
	}
	
	public void liberaQuarto(){
		setDisponibilidade(true);
	}
	
	public float calculaLucro(float entrada){
		if(entrada <0){
			throw new ValorInvalidoException("Valor de entrada nao pode ser negativo");
		} else if (entrada == 0){
			throw new ValorInvalidoException("Valor de entrada nao pode ser zero");
		}
		return preco * numReservas - entrada;
	}
	
	public String imprimeQtdEstrelas(){
		Estrela estrela = new Estrela();
		try {
			return estrela.ranqueiaQuarto(this);
		} catch (QuartoNuloException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Quarto [numero=");
		builder.append(numero);
		builder.append(", andar=");
		builder.append(andar);
		builder.append(", disponibilidade=");
		builder.append(disponibilidade);
		builder.append(", preco=");
		builder.append(preco);
		builder.append(", numReservas=");
		builder.append(numReservas);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Quarto other = (Quarto) obj;
		if (andar != other.andar)
			return false;
		if (numReservas != other.numReservas)
			return false;
		if (numero != other.numero)
			return false;
		if (Float.floatToIntBits(preco) != Float.floatToIntBits(other.preco))
			return false;
		if (disponibilidade != other.disponibilidade)
			return false;
		return true;
	}
	
	
}
