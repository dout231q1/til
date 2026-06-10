import java.util.*;

public class Main{

    static List<String> lista = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    static void listaDePessoas(){
        System.out.println("Cadastro de pessoas");


        System.out.println("1. Cadastrar usuario pelo nome");
        System.out.println("2. Remover usuario pelo nome");
        System.out.println("3. Encontrar usuario cadastrado pelo nome");
        System.out.println("4. Listar usuarios cadastrados");
        System.out.println("5. Sair do programa");
        System.out.print("Digite uma opcao de 1-5: ");
        int opcao = scanner.nextInt();
        scanner.nextLine();

        switch(opcao){
            case 1 -> cadastrarUsuarios();
            case 2 -> removerUsuarios();
            case 3 -> encontrarUsuarios();
            case 4 -> listarUsuarios();
            case 5 -> sairDoPrograma();
            default -> System.out.println("Opcao invalida!");
        }
    }

    static void limparConsole(){
        for(int i = 0; i < 50; i++){
            System.out.println();
        }
    }

    static void cadastrarUsuarios(){
        limparConsole(); // limpa tela
        System.out.println("Digite o nome do usuario para cadastrar");
        String nome = scanner.nextLine();
        lista.add(nome);
        System.out.printf("Usuario %s cadastrado com sucesso!%n", nome);
    }

    static void removerUsuarios(){
        limparConsole();
        System.out.println("Digite o nome do usuario para remover");
        String nome = scanner.nextLine();
        boolean removido = lista.removeIf(usuario -> usuario.equalsIgnoreCase(nome));
        if (removido){
            System.out.printf("Usuario %s removido com sucesso!%n", nome);
        } else {
            System.out.println("Usuario nao encontrado!");
        }
    }

    static void encontrarUsuarios(){
        limparConsole();
        System.out.println("Digite o nome do usuario para encontrar-lo");
        String nome = scanner.nextLine();
        String nomeOriginal = null;
        boolean existe = false;
        for(String usuario : lista){
            if(usuario.equalsIgnoreCase(nome)){
                nomeOriginal = usuario;
                existe = true;
                break;
            }
        }

        if(existe){
            System.out.printf("Usuario %s encontrado com sucesso!%n", nomeOriginal);
        } else {
            System.out.println("Usuario nao encontrado!");
        }
    }

    static void listarUsuarios(){
        limparConsole();
        for(String nome : lista){
            System.out.println(nome);
        }
    }

    static void sairDoPrograma(){
        System.out.println("Saindo...");
        System.exit(0);
    }
    public static void main(String[] args){
        while(true){
            listaDePessoas();
        }
    }
}