package dio.desafio.sistemaBancario;

public class ContaCorrente extends Conta {
	/* Eu estarei usando os números para rendimento, taxas e
	 * outros direto dos atributos de uma conta corrente CAIXA */
	
	double rendimento = 0.5;
	double custoMensal = 12.4;
	
	double taxaSaque = 2.30;
	/* Essa taxaDOC ira ficar aqui, mesmo sem ser utilizada. A diferenca entre
	 * uma TED e uma DOC, a ultima praticamente obsoleta, nao e grande o
	 * suficiente para justificar um novo metodo! */
	double taxaDOC = 8.65;
	double taxaTED = 8.65;
	
	public ContaCorrente(String nome, int numAgencia, int numConta, int senha) {
		super(nome, numAgencia, numConta, senha);
		// TODO Auto-generated constructor stub
	}
	
	/* Esse metodo finalDeMes teria de ser chamado por uma outra classe/metodo,
	 * este que iria agir em paralelo, ao longo de meses, e isso esta alem dos
	 * meus conhecimentos, e do escopo deste projeto! */
//	private void finalDeMes() {
//		super.saldo += super.saldo * rendimento;
//		super.saldo -= custoMensal;
//	}

	@Override
	protected void transferir(int valorTransferido, Conta contaDestino, int senha) {
		super.transferir((int)(valorTransferido + taxaTED), contaDestino, senha);
	}

	/* Neste caso, so o que vai importar e a taxaSaque, ja que a transferencia
	 * esta desativada para o usuario (embora possa ser executada com codagem).
	 * Eu decidi trabalhar o programa inteiro com Integers, isso para manter as
	 * coisas simples. Desta forma, o .30 da taxa de saque é sempre descartado! */
	
	@Override
	protected void sacar(int valorSacado, int senha) {
		super.sacar((int)(valorSacado + taxaSaque), senha);
	}
}
