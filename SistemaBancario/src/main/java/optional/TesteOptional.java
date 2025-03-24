package optional;

import collections.set.Conta;
import java.util.Optional;

public class TesteOptional {

    public static void main(String[] args) {

        Optional<Conta> optionalConta = obtemContaSemErro();

        if(optionalConta.isPresent()) {
            System.out.println("Saldo: " + optionalConta.get().getSaldo());
        } else {
            System.out.println("A conta não foi localizada!");
        }
    }

    public static Conta obtemConta() {
        return null;
    }

    public static Optional<Conta> obtemContaSemErro() {
        return Optional.of(Conta.builder()
                .numeroConta(1L)
                .saldo(300.00)
                .build());
    }

}
