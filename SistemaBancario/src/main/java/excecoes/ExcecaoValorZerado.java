package excecoes;

public class ExcecaoValorZerado extends Exception {

    public String  getMessage(){
        return "Valor para saque não pode ser 0";
    }
}
