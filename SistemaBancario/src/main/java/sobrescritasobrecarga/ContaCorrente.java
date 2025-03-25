package sobrescritasobrecarga;

public class ContaCorrente extends Conta {
    public ContaCorrente(Double saldo) {
        super(saldo);
    }


    public void sacar(Double valor) {
        this.saldo -= valor;
    }

    public void sacar(Double valor, Double taxaOperacao) {
        this.saldo -= valor + taxaOperacao;
    }
}

