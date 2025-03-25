package switchsample;

public class TesteSwitch {
    public static void main(String[] args) {
        Conta contaCorrente = new ContaCorrente();
        Conta contaPoupanca = new ContaPoupanca();

        exibeTipoConta(contaCorrente);
        exibeTipoConta(contaPoupanca);
        exibeTipoContaJava17(contaCorrente);
    }

    //ESTRUTURA PADRÃO
    private static void exibeTipoConta(Conta conta) {
        switch (conta.getTipoConta()) {
            case "Conta Corrente":
                System.out.println("É uma conta corrente.");
                break;
            case "Conta Comum":
                System.out.println("É uma conta comum.");
                break;
            case "Conta Poupanca":
                System.out.println("É uma conta poupança.");
                break;
            default:
                System.out.println("Não identificado o tipo de conta");
        }
    }

    //ESTRUTURA SIMPLIFICADA
    private static void exibeTipoContaJava17(Conta conta) {
        String mensagem = switch (conta.getTipoConta()) {
            case "Conta Corrente" -> "É uma conta corrente.";
            case "Conta Comum" -> "É uma conta comum.";
            case "Conta Poupanca" -> "É uma conta poupança.";
            default -> "Não identificado o tipo de conta.";
        };

        System.out.println(mensagem);
    }
}
