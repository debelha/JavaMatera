package interfaces;

public class TesteInterface {
    public static void main(String[] args) {
        ContaCorrente contaCorrente = new ContaCorrente();
        contaCorrente.depositar(5000.00);
        System.out.println("Saldo Conta Corrente após depósito: " + contaCorrente.getSaldo());
        contaCorrente.sacar(1000.00);
        System.out.println("Saldo Conta Corrente após o saque: " + contaCorrente.getSaldo());

        ContaPoupanca contaPoupanca = new ContaPoupanca();
        contaPoupanca.depositar(1500.00);
        System.out.println("Saldo Conta Poupança após depósito: " + contaPoupanca.getSaldo());
        contaPoupanca.sacar(800.00);
        System.out.println("Saldo Conta Poupança após o saque: " + contaPoupanca.getSaldo());
    }
}
