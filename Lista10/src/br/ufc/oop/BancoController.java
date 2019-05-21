package br.ufc.oop;

import java.util.Scanner;

public class BancoController {
	private Scanner s;
	
	
	public BancoController() {
		s = new Scanner(System.in);
		
	}

	public int menuPrincipal(){
		StringBuilder sb = new StringBuilder();
		
		sb.append("MENU PRINCIPAL");
		
		sb.append("[1] Criar Conta");
		sb.append("[2] Selecionar Conta");
		sb.append("[3] Remover Conta");
		sb.append("[4] Gerar Relatorio");
		sb.append("[5] Finalizar");	
		System.out.println(sb.toString());
		return s.nextInt();
	}
	
	public int criarConta(){
		
		StringBuilder sb = new StringBuilder();
		sb.append("CRIAR CONTA");
		sb.append("[1] Conta Corrente");
		sb.append("[2] Conta Poupança");
		return s.nextInt();
	}
	
	public ContaCorrente criarContaCorrente(){
		
		System.out.println("NOVA CONTA CORRENTE");
		System.out.println("\n Digite o numero da conta:");
		int numeroConta = Integer.parseInt(s.nextLine());
		System.out.println("\n Digite o saldo inicial:");
		double saldoInicial = s.nextDouble();
		System.out.println("\n Digite a taxa de operação:");
		double taxa = s.nextDouble();
		return new ContaCorrente(numeroConta, saldoInicial, taxa);
		
	}
	

	
}
