package br.ufc.test;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

import br.ufc.Quarto;
import br.ufc.exception.QuartoNuloException;
import br.ufc.exception.NumeroInvalidoException;
import br.ufc.exception.PrecoInvalidoException;

public class QuartoTest {


	@Test
	public void testReservaQuarto() {
		Quarto quarto = new Quarto(132, 1, 200);
		
			assertTrue(quarto.isDisponibilidade());
		
		int init = quarto.getNumReservas();
		quarto.reservaQuarto();
		
			assertFalse(quarto.isDisponibilidade());
		
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
	
	@Test(expected = PrecoInvalidoException.class)
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
	
	@Test(expected = PrecoInvalidoException.class)
	public void testValorNegativoDiaria(){
			
		Quarto quarto = new Quarto(123, 1, -150);
	}
	
	@Test(expected = NumeroInvalidoException.class)
	public void testAndarNegativo(){
		Quarto quarto = new Quarto(-123, 1, 150);
	}
	
	@Test(expected = PrecoInvalidoException.class)
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
	
	@Test
	public void testLucroNegativo(){
		Quarto quarto = new Quarto(123, 1, 100);
		assert quarto.calculaLucro(1000) == 0;
	}
	

}
