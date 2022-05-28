package dio.desafio.sistemaBancario;

public class ContaPoupanca extends Conta {
	/* O Eclipse me obrigou a colocar esta funcao construtora */
	public ContaPoupanca(String nome, int numAgencia, int numConta, int senha) {
		super(nome, numAgencia, numConta, senha);
	}
	
	/* A taxa referencial diaria (TR) do Banco Central e algo
	 * muito complexo, por isso usarei um valor dummy */
	double TR = 0.60;
	/* O rendimento mensal de uma poupanca caixa e 0.5% ao mes
	 * mais a taxa referencial diaria do BC */
	double rendimento = 0.5 + TR;
	
	/* Esse metodo finalDeMes teria de ser chamado por uma outra classe/metodo,
	 * este que iria agir em paralelo, ao longo de meses, e isso esta alem dos
	 * meus conhecimentos, e do escopo deste projeto! */
//	private void finalDeMes() {
//		super.saldo += super.saldo * rendimento;
//	}
}
