package excecoes;

public class TesteExcecao {
    public static void main(String[] args) throws Exception {
        Conta conta = new Conta();

        conta.setSaldo(1000.00);
        conta.setTaxaOperacao(0.5);

        try {
            conta.sacar(0.00);
        } catch (ExcecaoValorZerado e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Saldo da conta: " + conta.getSaldo());
        }
    }
}
