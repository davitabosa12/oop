package br.ufc.test;

import static org.junit.Assert.*;

import org.junit.Test;

import br.ufc.*;
import br.ufc.exception.QuartoNuloException;
public class EstrelaTest {

	@Test
	public void testRanqueiaQuarto() throws QuartoNuloException {
		
		final float PRECO_QUARTO = 214;
		
		Quarto quarto = new Quarto(123, 1 , PRECO_QUARTO);
		
		
		Estrela estrela = new Estrela();
		String s = estrela.ranqueiaQuarto(quarto);
		assertEquals(PRECO_QUARTO % 5 + "", s);
	}
	
	@Test(expected = QuartoNuloException.class)
	public void testQuartoNulo() throws QuartoNuloException{
		Estrela estrela = new Estrela();
		estrela.ranqueiaQuarto(null);
	}

}
