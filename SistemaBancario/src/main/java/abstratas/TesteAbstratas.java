package abstratas;

public class TesteAbstratas {
    public static void main(String[] args) {
        ContaCorrente contaCorente = new ContaCorrente();
        contaCorente.imprimeExtrato();

        ContaPoupanca contaPoupanca = new ContaPoupanca();
        contaPoupanca.imprimeExtrato();
    }
}
