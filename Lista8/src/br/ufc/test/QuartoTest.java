package br.ufc.test;

import static org.junit.Assert.*;


import br.ufc.ValorInvalidoException;
import br.ufc.QuartoNuloException;

import java.util.Random;

import org.junit.Test;

import br.ufc.Quarto;

public class QuartoTest {


	@Test
	public void testReservaQuarto() {
		Quarto quarto = new Quarto(132, 1, 200);
		assertTrue(quarto.isDisponibilidade());
		int init = quarto.getNumReservas();
		quarto.reservaQuarto();
		assertFalse(quarto.isDisponibilidade());
		System.out.println(init);
		System.out.println(quarto.getNumReservas());
		
		assert init < quarto.getNumReservas();
	}

	@Test
	public void testLiberaQuarto() {
		Quarto quarto = new Quarto(132, 1, 200);
		int init = quarto.getNumReservas();
		quarto.liberaQuarto();
		assertTrue(quarto.isDisponibilidade());
		
		assert init == quarto.getNumReservas();
	}

	@Test
	public void testCalculaLucro() {
		Random random = new Random();
		final int NUMERO_RESERVAS = random.nextInt(200);
		final float PRECO_QUARTO = random.nextInt(1000);
		final float INVESTIMENTO = 5000.0f;
		
		Quarto quarto = new Quarto(123, 1, PRECO_QUARTO);
		quarto.setNumReservas(NUMERO_RESERVAS);
		float expected = (NUMERO_RESERVAS * PRECO_QUARTO) - INVESTIMENTO;
		assert expected == quarto.calculaLucro(INVESTIMENTO);
	}
	
	@Test(expected = ValorInvalidoException.class)
	public void testValorNegativo(){
		Random random = new Random();
		final int NUMERO_RESERVAS = random.nextInt(200);
		final float PRECO_QUARTO = random.nextInt(1000);
		final float INVESTIMENTO = -5000.0f;
		
		Quarto quarto = new Quarto(123, 1, PRECO_QUARTO);
		quarto.setNumReservas(NUMERO_RESERVAS);
		float expected = (NUMERO_RESERVAS * PRECO_QUARTO) - INVESTIMENTO;
		assert expected == quarto.calculaLucro(INVESTIMENTO);
	}
	
	@Test(expected = ValorInvalidoException.class)
	public void testValorZero(){
		Random random = new Random();
		final int NUMERO_RESERVAS = random.nextInt(200);
		final float PRECO_QUARTO = random.nextInt(1000);
		final float INVESTIMENTO = 0f;
		
		Quarto quarto = new Quarto(123, 1, PRECO_QUARTO);
		quarto.setNumReservas(NUMERO_RESERVAS);
		float expected = (NUMERO_RESERVAS * PRECO_QUARTO) - INVESTIMENTO;
		assert expected == quarto.calculaLucro(INVESTIMENTO);
	}
	

}
