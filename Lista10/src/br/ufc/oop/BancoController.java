package br.ufc.oop;

import java.util.Scanner;

import br.ufc.oop.exception.ContaExistenteException;
import br.ufc.oop.exception.ContaNaoEncontradaException;
import br.ufc.oop.exception.DepositoSemSucessoException;
import br.ufc.oop.exception.SaqueSemSucessoException;
import br.ufc.oop.exception.TransferenciaSemSucessoException;

public class BancoController {
	private Scanner s;
	private Banco banco;
	private Estado estado; // estado do programa (menu principal, finalizando...)
	
	
	public BancoController() {
		s = new Scanner(System.in);
		banco = new Banco();
		voltarAoMenuPrincipal();
		
	}
	public BancoController(Banco banco) {
		s = new Scanner(System.in);
		if (banco != null) {
			this.banco = banco;	
		} else {
			this.banco = new Banco();
		}
		voltarAoMenuPrincipal();
	}
	
	public void loop() {
		while(estado != Estado.FINALIZAR) {
			switch(estado) {
			case MENU:
				menuPrincipal();
				break;
			case CRIAR_CONTA:
				criarConta();
				break;
			case SELECIONAR_CONTA:
				selecionarConta();
				break;
			case REMOVER_CONTA:
				removerConta();
				break;
			case GERAR_RELATORIO:
				gerarRelatorio();
				break;
			case FINALIZAR:
				finalizar();
				break;
			}
		}
	}

	private void finalizar() {
		
		
	}
	public void menuPrincipal(){
		StringBuilder sb = new StringBuilder();
		
		sb.append("MENU PRINCIPAL");
		
		sb.append("\n[1] Criar Conta");
		sb.append("\n[2] Selecionar Conta");
		sb.append("\n[3] Remover Conta");
		sb.append("\n[4] Gerar Relatorio");
		sb.append("\n[5] Finalizar");
		sb.append("\n");
		System.out.println(sb.toString());
		int operacao = 0;
		s.reset();
		if(s.hasNextInt())
			operacao = s.nextInt();
		switch(operacao) {
			case 1:
				estado = Estado.CRIAR_CONTA;
				break;
			case 2:
				estado = Estado.SELECIONAR_CONTA;
				break;
			case 3:
				estado = Estado.REMOVER_CONTA;
				break;
			case 4:
				estado = Estado.GERAR_RELATORIO;
				break;
			case 5:
				estado = Estado.FINALIZAR;
				break;
			default:
				System.err.println("Operacao invalida");
				break;
		}
	}
	
	public void gerarRelatorio() {
		Relatorio.gerarRelatorio(banco);
		voltarAoMenuPrincipal();
	}
	
	public void removerConta() {
		StringBuilder sb = new StringBuilder();
		sb.append("\nREMOVER CONTA");
		sb.append("\nDigite o numero da conta:\n");
		System.out.println(sb.toString());
		int numeroConta = s.nextInt();
		try {
			ContaBancaria conta = banco.procurarConta(numeroConta);
			banco.remover(conta);
			System.out.println("\nConta removida com sucesso");
			voltarAoMenuPrincipal();
		} catch (ContaNaoEncontradaException e) {
			// TODO Auto-generated catch block
			System.err.println("Conta nao encontrada");
		}
	}
	
	public void selecionarConta() {
		StringBuilder sb = new StringBuilder();
		sb.append("\nSELECIONAR CONTA");
		sb.append("\nDigite o numero da conta:\n");
		System.out.println(sb.toString());
		int numeroConta = s.nextInt();
		try {
			ContaBancaria conta = banco.procurarConta(numeroConta);
			operarConta(conta);
		} catch (ContaNaoEncontradaException e) {
			System.err.println("\nConta nao encontrada");
			voltarAoMenuPrincipal();
			return;
		}
	}
	
	public void operarConta(ContaBancaria conta) {
		int operacao = 0;
		while(operacao != 5) {
			StringBuilder sb = new StringBuilder();
			sb.append("CONTA ").append(conta.numeroConta);
			
			sb.append("\n[1] Depositar");
			sb.append("\n[2] Sacar");
			sb.append("\n[3] Transferir");
			sb.append("\n[4] Gerar Relatorio");
			sb.append("\n[5] Voltar ao menu anterior\n");
			System.out.println(sb.toString());
			operacao = s.nextInt();
			switch(operacao) {
				case 1:
					depositar(conta);
					break;
				case 2:
					sacar(conta);
					break;
				case 3:
					transferir(conta);
					break;
				case 4:
					Relatorio.gerarRelatorio(conta);
					break;
				case 5:
				voltarAoMenuPrincipal();
					break;
				default:
					System.out.println("Operacao invalida");
					break;
			}
		}
	}
	private void voltarAoMenuPrincipal() {
		estado = Estado.MENU;
	}
	
	private void transferir(ContaBancaria conta) {
		System.out.println("\nDigite o valor da transferencia: ");
		double valor = s.nextDouble();
		System.out.println("\nDigite o numero da conta do favorecido: ");
		int numeroConta = s.nextInt();
		ContaBancaria favorecido;
		try {
			
			favorecido = banco.procurarConta(numeroConta);
		} catch (ContaNaoEncontradaException e) {
			// TODO Auto-generated catch block
			System.err.println("\nConta informada nao encontrada.");
			return;
		}
		try {
			conta.transferir(valor, favorecido);
			System.out.println("\nTransferido R$" + valor +  " de " + conta.numeroConta + " para " + favorecido.numeroConta + ".");
		} catch (TransferenciaSemSucessoException e) {
			// TODO Auto-generated catch block
			System.err.println("\nTransferencia sem sucesso: " + e.getMessage());
		}
		
		
	}
	private void sacar(ContaBancaria conta) {
		System.out.println("Digite o valor a ser sacado: ");
		double valor = s.nextDouble();
		try {
			conta.sacar(valor);
			System.out.println("Sacado R$ " + valor + " da conta " + conta.numeroConta);
		} catch (SaqueSemSucessoException e) {
			System.err.println("Nao foi possivel sacar: saldo insuficiente");
		}
		
	}
	private void depositar(ContaBancaria conta) {
		System.out.println("Digite o valor a ser depositado: ");
		double valor = s.nextDouble();
		try {
			conta.depositar(valor);
			System.out.println("Depositado R$ " + valor + " na conta " + conta.numeroConta);
		} catch (DepositoSemSucessoException e) {
			System.err.println("Nao foi possivel depositar: valor menor que o saldo + taxa de operacao");
		}
	}
	public void criarConta(){
		
		StringBuilder sb = new StringBuilder();
		sb.append("\nCRIAR CONTA");
		sb.append("\n[1] Conta Corrente");
		sb.append("\n[2] Conta Poupanca");
		sb.append("\n[3] Cancelar");
		System.out.println(sb.toString());
		int op = s.nextInt();
		while(op != 3) {
			switch(op) {
			case 1:
				criarContaCorrente();
				break;
			case 2:
				criarContaPoupanca();
				break;
			default:
				System.err.println("Operacao invalida");
				break;
			}
			op =3;
		}
		voltarAoMenuPrincipal();
		
	}
	
	public void criarContaCorrente(){
		
		System.out.println("NOVA CONTA CORRENTE");
		System.out.println("\n Digite o numero da conta:");
		int numeroConta = s.nextInt();
		System.out.println("\n Digite o saldo inicial:");
		double saldoInicial = s.nextDouble();
		System.out.println("\n Digite a taxa de operacao:");
		double taxa = s.nextDouble();
		try {
			banco.inserir(new ContaCorrente(numeroConta, saldoInicial, taxa));
			System.out.println("Conta corrente criada com sucesso");
			voltarAoMenuPrincipal();
		} catch (ContaExistenteException e) {
			// TODO Auto-generated catch block
			System.err.println("Erro ao criar conta corrente: " + e.getMessage());
		} finally {
			voltarAoMenuPrincipal();			
		}
		
	}
	
	public void criarContaPoupanca() {
		System.out.println("NOVA CONTA POUPANCA");
		System.out.println("\n Digite o numero da conta:");
		int numeroConta = Integer.parseInt(s.nextLine());
		System.out.println("\n Digite o saldo inicial:");
		double saldoInicial = s.nextDouble();
		System.out.println("\n Digite o limite:");
		double limite = s.nextDouble();
		try {
			banco.inserir(new ContaPoupanca(numeroConta, saldoInicial, limite));
			System.out.println("Conta Poupanca criada com sucesso");
			
		} catch (ContaExistenteException e) {
			// TODO Auto-generated catch block
			System.err.println("Erro ao criar conta poupanca: " + e.getMessage());
		}
		voltarAoMenuPrincipal();
	}
	
	public enum Estado{
		MENU, CRIAR_CONTA, SELECIONAR_CONTA, REMOVER_CONTA, GERAR_RELATORIO, FINALIZAR,
	}

	
}
