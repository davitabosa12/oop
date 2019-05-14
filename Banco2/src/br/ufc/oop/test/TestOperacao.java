package br.ufc.oop.test;

import static org.junit.Assert.*;

import org.junit.Test;

import br.ufc.oop.Saque;
import br.ufc.oop.exception.ValorInvalidoException;

public class TestOperacao {

	@Test
	public void testeSaqueToString(){
		final int NUMERO_SAQUE = 1864;
		final float VALOR_SAQUE = 43468;
		final String teste = "Saque [valor=" + VALOR_SAQUE + ", numeroOrigem=" + NUMERO_SAQUE + "]";
		System.out.println(teste);
		Saque s = new Saque(VALOR_SAQUE, NUMERO_SAQUE);
		System.out.println(s.toString());
		assert teste.equals(s.toString());
	}
	
	@Test(expected = ValorInvalidoException.class)
	public void testeSaqueInvalido(){
		final int NUMERO_SAQUE = 1864;
		final float VALOR_SAQUE = 0;;
		Saque s = new Saque(VALOR_SAQUE, NUMERO_SAQUE);
	}

}
