package switchsample;

public class ContaCorrente implements Conta{
    private final String tipoConta;

    public ContaCorrente(){
        this.tipoConta = "Conta Corrente";
    }

    public String getTipoConta() {
        return this.tipoConta;
    }
}
