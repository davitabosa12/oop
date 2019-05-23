package br.ufc.oop;

import java.util.ArrayList;
import java.util.List;

import br.ufc.oop.exception.ContaExistenteException;
import br.ufc.oop.exception.ContaNaoEncontradaException;

public class Banco implements Imprimivel{
	private List<ContaBancaria> contas;
	
	
	public Banco() {
		contas = new ArrayList<>();
	}
	
	public void inserir(ContaBancaria conta) throws ContaExistenteException{
		try {
			procurarConta(conta);
			throw new ContaExistenteException("A conta " + conta +" ja existe");
		} catch (ContaNaoEncontradaException e) {
			contas.add(conta);
		}
		
	}
	
	private ContaBancaria procurarConta(ContaBancaria conta) throws ContaNaoEncontradaException{
		for(ContaBancaria c : contas){
			if(c.equals(conta))
				return c;
		}
		
		throw new ContaNaoEncontradaException("A conta " + conta.numeroConta + " não consta no sistema.");
	}

	public void remover(ContaBancaria conta){
		contas.remove(conta);
	}
	
	public ContaBancaria procurarConta(int numeroConta) throws ContaNaoEncontradaException{
		for(ContaBancaria c : contas){
			if(c.getNumeroConta() == numeroConta){
				return c;
			}
		}
		throw new ContaNaoEncontradaException("O numero " + numeroConta + " não consta no sistema.");
	}

	@Override
	public void mostrarDados() {
		System.out.println("=================BANCO==================");
		for(ContaBancaria c : contas){
			System.out.print("\t");
			c.mostrarDados();
		}
		System.out.println("\nFIM DO RELATORIO");
	}
	
	

}
