package dio.desafio.sistemaBancario;

import java.util.Scanner;

public class Banco {
	public static void main(String args[]) {
		String nome;
		int numAgencia;
		int numConta;
		int senha;

		Scanner teclado = new Scanner(System.in);

		System.out.print("Olá, bem-vindo ao Banco Generico. Você gostaria de criar"
		    + " uma conta? (S/N) ");

		/* Nao ha motivo para alguem NAO querer criar uma conta, depois de ter
		 * executado este programa, por isso desativei o if! */
//		if (teclado.next() == "S") {
		System.out.print("Informe um nome para a conta: ");
		nome = teclado.nextLine();
		System.out.print("Informe o numero da agencia: ");
		numAgencia = teclado.nextInt();
		System.out.print("Informe o numero da conta: ");
		numConta = teclado.nextInt();
		System.out.print("Informe a nova senha: ");
		senha = teclado.nextInt();

		/* Aqui esta um problema: a IDE nao permitira que o objeto dioDesafio
		 * seja declarado dentro de um if e entao referenciado mais embaixo
		 * no codigo. Por essa razao, criaremos uma conta corrente por padrao! */
//		System.out.println("Você gostaria de criar uma (1) conta corrente"
//				+ " ou uma (2) poupança?");
//		if (teclado.nextInt() == 1) {
//			Conta dioDesafio = new ContaCorrente(nome, numAgencia, numConta, senha);
//		} else if (teclado.nextInt() == 2) {
//			Conta dioDesafio = new ContaPoupanca(nome, numAgencia, numConta, senha);
//		}

		Conta dioDesafio = new ContaCorrente(nome, numAgencia, numConta, senha);
		
//		} else {}

		boolean rodar = true;
		while (rodar) {
			System.out.print("Agora, gostaria de (1) Depositar, (2) Sacar,"
					+ " (3) Transferir, (4) Exibir o Saldo, ou (5) Exibir o Extrato?" + " (0) Para Interromper Tudo ");
			
			int processo = teclado.nextInt();

			switch (processo) {
			case 1: // Depositar
				System.out.print("Digite o valor inteiro a ser depositado: ");
				int depositar1 = teclado.nextInt();
				System.out.print("Digite a senha da sua conta: ");
				int depositar2 = teclado.nextInt();
				dioDesafio.depositar(depositar1, depositar2);
				System.out.print("\n\n");
				break;
			case 2: // Sacar
				System.out.print("Digite o valor inteiro a ser sacado: ");
				int sacar1 = teclado.nextInt();
				System.out.print("Digite a senha da sua conta: ");
				int sacar2 = teclado.nextInt();
				dioDesafio.sacar(sacar1, sacar2);
				System.out.print("\n\n");
				break;
			case 3: // Transferir
				/* A funcao de transferir esta desativada pois eu nao sei como
				 * o usuario pode passar o objeto contaDestino a partir do teclado.
				 * No JavaScript existe o getElementById e getElementByName, que
				 * iriam tornar este processo facil, mas nao e este o caso aqui! */
//		    	System.out.print("Digite o valor inteiro a ser transferido: ");
//    	            int transferir1 = teclado.nextInt();
//    	        System.out.print("Digite o nome da conta destino: ");
//    	            Conta contaDestino = nome.getClass();
//    	        System.out.print("Digite a senha da sua conta: ");
//    	            int transferir3 = teclado.nextInt();
//    	        dioDesafio.transferir(transferir1, contaDestino, transferir3);
				System.out.print("\n\n");
//	    	    break;
			case 4: // Exibir Saldo
				dioDesafio.imprimeSaldo();
				System.out.print("\n\n");
				break;
			case 5: // Exibir Extrato
				dioDesafio.imprimeExtrato();
				System.out.print("\n\n");
				break;
			case 0:
				rodar = false;
				break;
			default:
				System.out.println("Error! Opcao invalida!");
				break;
			}
		}
		
		System.out.print("Finalizado!");

		teclado.close();
	}
}
