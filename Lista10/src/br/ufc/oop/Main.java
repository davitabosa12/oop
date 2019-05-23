package br.ufc.oop;

import br.ufc.oop.exception.DepositoSemSucessoException;
import br.ufc.oop.exception.SaqueSemSucessoException;

public class Main {
	
	public static void main(String[] args){
		BancoController bc = new BancoController();
		bc.loop();
		
	}
}
