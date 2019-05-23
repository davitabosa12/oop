package br.ufc.oop.test;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;

import br.ufc.oop.PJuridica;

public class PJuridicaTest {

	PJuridica pj;
	@Before
	public void setUp() throws Exception {
		pj = new PJuridica("juridica", 0, "");
	}

	@Test
	public void testCalcularImposto() {
		double renda = new Random().nextDouble() * 10000;
		pj.setRendaBruta(renda);
		assert renda * 0.1 == pj.calcularImposto();
	}

}
