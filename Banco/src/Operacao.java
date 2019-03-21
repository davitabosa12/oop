
public class Operacao {
	
	private TipoOperacao tipo;
	private float valor;
	
	
	
	
	public Operacao(TipoOperacao tipo, float valor) {
		this.tipo = tipo;
		this.valor = valor;
	}




	public TipoOperacao getTipo() {
		return tipo;
	}




	public void setTipo(TipoOperacao tipo) {
		this.tipo = tipo;
	}




	public float getValor() {
		return valor;
	}




	public void setValor(float valor) {
		this.valor = valor;
	}




	enum TipoOperacao{
		SAQUE, DEPOSITO
	}
}
