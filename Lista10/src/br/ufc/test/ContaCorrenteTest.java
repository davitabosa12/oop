package br.ufc.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.ufc.oop.ContaCorrente;
import br.ufc.oop.exception.DepositoSemSucessoException;
import br.ufc.oop.exception.SaqueSemSucessoException;

public class ContaCorrenteTest {
	
	ContaCorrente cc;
	@Before
	public void setUp() throws Exception {
		cc = new ContaCorrente(123, 1000, 1);
	}

	@Test
	public void testSacar() throws SaqueSemSucessoException {
		cc.sacar(100);
		assert cc.getSaldo() == 899.0d;
	}
	
	@Test(expected = SaqueSemSucessoException.class)
	public void testSacarFail() throws SaqueSemSucessoException {
		cc.mostrarDados();
		cc.sacar(2000);
	}
	
	@Test
	public void testDepositar() throws DepositoSemSucessoException {
		cc.depositar(300);
	}
	
	@Test(expected = DepositoSemSucessoException.class)
	public void testDepositarFail() throws DepositoSemSucessoException {
		ContaCorrente ccFail = new ContaCorrente(123, 100, 200);
		ccFail.depositar(5);
	}

}
