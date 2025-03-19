package lombok;

public class TestePessoa {
    public static void main(String[] args) {
        Pessoa pessoa1 = new Pessoa();

        pessoa1.setId(1L);
        pessoa1.setNome("Deborah");
        pessoa1.setIdade(26);

        System.out.println("ID: " + pessoa1.getId());
        System.out.println("Nome: " + pessoa1.getNome());
        System.out.println("Idade: " + pessoa1.getIdade());
    }
}
