package sobrescritasobrecarga;

public class TesteSobrescritaSobrecarga {
    public static void main(String[] args) {
        ContaPoupanca contaPoupanca = new ContaPoupanca( 6000.00);
        contaPoupanca.depositar(500.00);

        ContaCorrente contaCorrenteSemTaxa = new ContaCorrente( 9000.00);
        contaCorrenteSemTaxa.sacar(1000.00);

        ContaCorrente contaCorrenteComTaxa = new ContaCorrente( 9000.00);
        contaCorrenteComTaxa.sacar(1000.00, 0.50);

        System.out.println("Saldo Conta Poupança: " + contaPoupanca.getSaldo());
        System.out.println("Saldo Conta Corente sem taxa: " + contaCorrenteSemTaxa.getSaldo());
        System.out.println("Saldo Conta Corente com taxa: " + contaCorrenteComTaxa.getSaldo());
    }
}
