package interfaces;

public class TesteInterface {
    public static void main(String[] args) {
        ContaCorrente contaCorrente = new ContaCorrente();
        contaCorrente.depositar(5000.00);
        contaCorrente.getSaldo();
        System.out.println(contaCorrente.getSaldo());

        ContaPoupanca contaPoupanca = new ContaPoupanca();
        contaPoupanca.depositar(1500.00);
        contaPoupanca.getSaldo();
        System.out.println(contaPoupanca.getSaldo());
    }
}
