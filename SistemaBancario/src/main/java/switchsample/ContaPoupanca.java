package switchsample;

public class ContaPoupanca implements Conta{
    private final String tipoConta;

    public ContaPoupanca() {
        tipoConta = "Conta Poupanca";
    }

    @Override
    public String getTipoConta() {
        return this.tipoConta;
    }
}
