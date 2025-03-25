package sobrescritasobrecarga;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Conta {
    protected Double saldo;
    protected Double taxaOperacao;

    public Conta(Double saldo) {
        this.saldo = saldo;
        this.taxaOperacao = 0.45;
    }

    public void depositar(Double valor) {
        this.saldo += valor - taxaOperacao;
    }
}
