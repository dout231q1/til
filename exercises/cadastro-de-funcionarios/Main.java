import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    static class Funcionario {
        String nome;
        String cargo;
        double salario;

        public Funcionario (String nome, String cargo, double salario){
            this.nome = nome;
            this.cargo = cargo;
            this.salario = salario;
        }
    }

    static void imprimirLista(List<Funcionario> lista){
        for(Funcionario funcionario : lista){
            System.out.println("Nome: " + funcionario.nome + ", Cargo: " + funcionario.cargo + ", Salario: " + funcionario.salario);
        }
    }

    public static void main(String[] args) {
        List<Funcionario> listaFuncionario = new ArrayList<>();
        listaFuncionario.add(new Funcionario("John", "Engenheiro de Software", 6000));
        listaFuncionario.add(new Funcionario("Harry", "Desenvolvedor Junior", 3000));
        listaFuncionario.add(new Funcionario("Peter", "Desenvolvedor Senior", 12000));
        listaFuncionario.add(new Funcionario("Connor", "DevOps", 9000));
        listaFuncionario.add(new Funcionario("Mike", "DBA", 7500));

        System.out.println("=====\nLista\n=====");

        imprimirLista(listaFuncionario); // metodo para imprimir a lista

        List<Funcionario> linkedListaFuncionario = new LinkedList<>(listaFuncionario);

        System.out.println("===========================\nLista apos adicao de George\n===========================");
        linkedListaFuncionario.add(2, new Funcionario("George", "Analista de Infraestrutura", 6500));
        imprimirLista(linkedListaFuncionario); // metodo para imprimir a lista apos a adicao do george

        System.out.println("============================\nLista apos remocao de Connor\n============================");
        linkedListaFuncionario.removeIf(funcionario -> funcionario.nome.equals("Connor"));
        imprimirLista(linkedListaFuncionario); // metodo para imprimir a lista apos a remocao do connor
    }
}
