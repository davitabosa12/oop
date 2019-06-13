package br.ufc.oop;

import java.util.ArrayList;
import java.util.List;

import br.ufc.oop.exception.ContaNaoExisteException;
import br.ufc.oop.exception.SaldoInsuficienteException;

public class Sistema {
	private List<XPTOConta> listaConta;
	public Sistema() {
		this.listaConta = new ArrayList<>();
	}
	
	public void criarXPTOBasic(int numeroConta) throws Exception{
		if(!contaExiste(numeroConta)){
			//crie a conta basic
			adicionar(new XPTOBasic(numeroConta));
		} else {
			throw new Exception("O numero informado ja existe");
		}
	}
	
	public void criarXPTOPlus(int numeroConta) throws Exception{
		if(!contaExiste(numeroConta)){
			//crie a conta basic
			adicionar(new XPTOPlus(numeroConta));
		} else {
			throw new Exception("O numero informado ja existe");
		}
	}
	
	public void criarXPTOExtreme(int numeroConta) throws Exception{
		if(!contaExiste(numeroConta)){
			//crie a conta basic
			adicionar(new XPTOExtreme(numeroConta));
		} else {
			throw new Exception("O numero informado ja existe");
		}
	}
	
	public void adicionar(XPTOConta conta){
		listaConta.add(conta);
	}
	public double consultarSaldo(int numeroConta) throws ContaNaoExisteException{
		int index = listaConta.indexOf(new XPTOBasic(numeroConta));
		if(index < 0) 
			throw new ContaNaoExisteException("A conta com numero " + numeroConta + " nao existe");
		return listaConta.get(index).consultarSaldo();	
	}
	
	public boolean contaExiste(int numeroConta){
		return listaConta.indexOf(new XPTOBasic(numeroConta)) > -1;
	}
	
	public void creditar(int numeroConta, double valor) throws ContaNaoExisteException{
		int index = listaConta.indexOf(new XPTOBasic(numeroConta));
		if(index < 0){
			throw new ContaNaoExisteException("A conta com numero " + numeroConta + " nao existe"); 
		}
		listaConta.get(index).creditar(valor);
	}
	
	public void debitar(int numeroConta, double valor) throws ContaNaoExisteException, SaldoInsuficienteException{
		int index = listaConta.indexOf(new XPTOBasic(numeroConta));
		if(index < 0){
			throw new ContaNaoExisteException("A conta com numero " + numeroConta + " nao existe"); 
		}
		listaConta.get(index).debitar(valor);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Sistema:\n");
		for(XPTOConta c : listaConta){
			sb.append(c.toString());
			sb.append("\n");
		}
		return sb.toString();
		
	}

}
