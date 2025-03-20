package collections.set;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TesteSet {
    public static void main(String[] args) {

        Set<String> contas = new HashSet<>();

        contas.add("Conta Poupança");
        contas.add("Conta Corrente");
        contas.add("Conta Pagamento");
        contas.add("Conta Poupança");

        contas.forEach(conta -> {
            System.out.println("Conta: " + conta);
            System.out.println("Hash: " + contas.hashCode());
        });
    }
}
