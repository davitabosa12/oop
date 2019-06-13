package br.ufc.oop.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.ufc.oop.Sistema;
import br.ufc.oop.exception.ContaNaoExisteException;

public class SistemaTest {
	Sistema s;
	@Before
	public void setUp() throws Exception {
		
		s = new Sistema();
		s.criarXPTOBasic(1);
		s.criarXPTOPlus(2);
		s.criarXPTOExtreme(3);
		for(int i = 1; i<=3; i++) s.creditar(i,1000);
		for(int i = 1; i<=3; i++) s.debitar(i,10);
	}

	@Test
	public void test() throws ContaNaoExisteException {
		System.out.println(s.toString());
		assert s.consultarSaldo(1) == 990 ;
		assert s.consultarSaldo(2) == 995 ;
		assert s.consultarSaldo(3) == 992.02 ;
	}

}
