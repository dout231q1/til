import java.time.LocalDate;
import java.util.*;

public class Main{

    static List<Livro> livros = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    static void biblioteca(){

        System.out.println("1. Adicionar livro");

        System.out.println("Digite uma opcao de 1-5");
        int opcao = scanner.nextInt();
        scanner.nextLine();


        switch(opcao){
            case 1 -> adicionarLivro();
        }
    }

    static void adicionarLivro(){
        System.out.println("Qual o nome do livro que voce gostaria de adicionar?");
        String titulo = scanner.nextLine();
        System.out.println("Qual o nome do autor deste livro?");
        String autor = scanner.nextLine();
        System.out.println("Qual a data de publicacao deste livro?");
        LocalDate dataPublicacao = LocalDate.parse(scanner.nextLine());
        livros.add(new Livro(titulo, autor, dataPublicacao));
        System.out.println("Livro adicionado com sucesso!");
    }

    public static void main(String[] args) {
        while(true){
            biblioteca();
        }
    }
}