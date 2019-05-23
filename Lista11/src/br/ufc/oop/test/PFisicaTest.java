package br.ufc.oop.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.ufc.oop.PFisica;

public class PFisicaTest {

	@Test
	public void testCalcularImpostoZero() {
		PFisica pf = new PFisica("fisica", 0, "");
		assert 0 == pf.calcularImposto();
		pf.setRendaBruta(1400);
		assert 0 == pf.calcularImposto();
	}
	@Test
	public void testCalcularImposto10() {
		PFisica pf = new PFisica("fisica", 1400.01, "");
		assert (1400.01 * 0.1) + 100 == pf.calcularImposto();
		pf.setRendaBruta(2100);
		assert (2100 * 0.1) + 100 == pf.calcularImposto();	
	}
	@Test
	public void testCalcularImposto15() {
		PFisica pf = new PFisica("fisica", 2100.01, "");
		assert (2100.01 * 0.15) + 270 == pf.calcularImposto();
		pf.setRendaBruta(2800);
		assert (2800 * 0.15) + 270 == pf.calcularImposto();
	}
	@Test
	public void testCalcularImposto25() {
		PFisica pf = new PFisica("fisica", 2800.01, "");
		assert (2800.01 * 0.25) + 500 == pf.calcularImposto();
		pf.setRendaBruta(3600);
		assert (3600 * 0.25) + 500 == pf.calcularImposto();
	}
	@Test
	public void testCalcularImposto30() {
		PFisica pf = new PFisica("fisica", 3600.01, "");
		assert (3600.01 * 0.30) + 700 == pf.calcularImposto();
	}
}
