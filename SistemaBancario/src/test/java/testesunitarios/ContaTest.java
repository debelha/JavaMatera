package testesunitarios;

import org.junit.Test;
import testeunitario.Conta;

import static org.junit.Assert.assertEquals;

public class ContaTest {
    Double saldo = 1000.00;
    Double taxaOperacao = 0.50;
    Double saldoFinal= 799.50;

    @Test
    public void sacarTest(){
        Conta conta = new Conta(saldo, taxaOperacao);
        conta.sacar(200.00);
        assertEquals(saldoFinal, conta.getSaldo());
    }
}
