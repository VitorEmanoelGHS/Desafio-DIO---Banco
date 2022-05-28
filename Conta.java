package dio.desafio.sistemaBancario;

import java.util.TreeMap;
import java.util.Map;

public class Conta {
	String nome;
	protected int numAgencia;
	protected int numConta;
	protected int senha;
	
	int saldo = 0;
	/* Esse extrato estará bugado pois todas as chaves sao as mesmas:
	 * isso porque eu nao consegui fazer com que o programa capturasse
	 * a data e o horario on-the-run; dessa forma, a classe Horario
	 * armazena o horario ao inicio da execucao e isso se mantem!
	 * Mas e uma ideia para um extrato que mostre os depositos (numeroes positivos)
	 * e saques (numeros negativos) realizados na conta! */
	Map<String, Integer> extrato = new TreeMap<>();
	Horario horario = new Horario();
	
	public Conta(String nome, int numAgencia, int numConta, int senha) {
		this.nome = nome;
		this.numAgencia = numAgencia;
		this.numConta = numConta;
		this.senha = senha;
	}
	
	public int getNumConta() {
		return numConta;
	}
	
	public int getNumAgencia() {
		return numAgencia;
	}
	
	protected void depositar(int valorDepositado, int senha) {
		if (senha == this.senha) {
		    saldo += valorDepositado;
            extrato.put(horario.getHorario(), valorDepositado);
		}
		else System.out.println("Senha Incorreta!");
	}
	
	protected void sacar(int valorSacado, int senha) {
		if (senha == this.senha) {
		    saldo -= valorSacado;
		    extrato.put(horario.getHorario(), valorSacado * (-1));
		}
		else System.out.println("Senha Incorreta!");
	}
	
	protected void transferir(int valorTransferido, Conta contaDestino, int senha) {
		if (senha == this.senha) {
			this.sacar(valorTransferido, senha);
		    contaDestino.depositar(valorTransferido, senha);
            extrato.put(horario.getHorario(), valorTransferido * (-1));
	    } else System.out.println("Senha Incorreta!");
	}
	
	protected void imprimeSaldo() {
		System.out.println(saldo);
	}
	
	protected void imprimeExtrato() {
		System.out.println("Usuário: " + nome + "\nConta: "
	        + numConta + "\nAgência: " + numAgencia + "\n\n" + extrato
	        + "\n\nSaldo: " + saldo);
	}
}
