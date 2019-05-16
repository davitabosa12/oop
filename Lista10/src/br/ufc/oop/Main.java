package br.ufc.oop;

public class Main {
	
	public static void main(String[] args){
		ContaCorrente cc = new ContaCorrente(1, 0, 0.5);
		ContaPoupanca poup = new ContaPoupanca(2, 0, 200);
		cc.depositar(1000);
		poup.depositar(100);
		
		cc.sacar(100);
		poup.sacar(200);
		Relatorio.gerarRelatório(cc);
		Relatorio.gerarRelatório(poup);
		
		
	}
}
