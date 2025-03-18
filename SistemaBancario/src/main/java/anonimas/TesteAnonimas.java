package anonimas;

public class TesteAnonimas {
    public static void main(String[] args) {
        CarteiraContas carteira = new CarteiraContas();
        carteira.contaCorrente.imprimeTipoConta();
        carteira.contaPoupanca.imprimeTipoConta();
    }
}
