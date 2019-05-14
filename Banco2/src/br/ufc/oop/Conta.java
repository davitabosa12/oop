package br.ufc.oop;
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
	
	public void saque(Saque s){
		saldo -= s.getValor();
		operacoes.add(s);
	}
	public void deposito(Transferencia t){
		saldo += t.getValor();
		operacoes.add(t);
	
	}
	
	public void extratoNUltimas(int n){
		for(int i = operacoes.size() -1; i < i -n; i--){
			System.out.println(operacoes.get(i).toString());
		}
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
