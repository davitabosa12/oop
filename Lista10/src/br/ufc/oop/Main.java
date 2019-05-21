package br.ufc.oop;

import br.ufc.oop.exception.DepositoSemSucessoException;
import br.ufc.oop.exception.SaqueSemSucessoException;

public class Main {
	
	public static void main(String[] args){
		ContaCorrente cc = new ContaCorrente(1, 0, 0.5);
		ContaPoupanca poup = new ContaPoupanca(2, 0, 200);
		try {
			cc.depositar(1000);
		} catch (DepositoSemSucessoException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		poup.depositar(100);
		
		try {
			cc.sacar(100);
			poup.sacar(200);
		} catch (SaqueSemSucessoException e) {
			e.printStackTrace();
		}
		
		Relatorio.gerarRelatório(cc);
		Relatorio.gerarRelatório(poup);
		
		
	}
}
