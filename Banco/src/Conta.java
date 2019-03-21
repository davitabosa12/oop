import java.util.ArrayList;
import java.util.List;

public class Conta {
	private int numero;
	private float saldo;
	private List<Operacao> operacoes;
	
	
	
	
	public Conta(int numero, float saldo) {
		this.operacoes = new ArrayList<>();
		this.numero = numero;
		this.saldo = saldo;
	}
	
	public void saque(Operacao op){
		
	}
	public void deposito(Operacao op){
		
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	
	public float getSaldo() {
		return saldo;
	}
	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	@Override
	public String toString() {
		return "Conta [numero=" + numero + ", saldo=" + saldo + "]";
	}
	
	
	
}
