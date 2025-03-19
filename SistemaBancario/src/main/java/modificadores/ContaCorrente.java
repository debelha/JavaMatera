package modificadores;

public class ContaCorrente {
    public static void main(String[] args) {
        Conta conta = new Conta(500.00);

        conta.setSaldo(10.00);
        conta.getSaldo();

    }
}
