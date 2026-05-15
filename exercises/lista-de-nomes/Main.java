import java.util.*;

public class Main{
    static void listaDeNomes(){
        List<String> lista = new ArrayList<>();
        lista.add("Harry");
        lista.add("John");
        lista.add("Pedro");
        lista.add("Arthur");
        lista.add("Robin");

        System.out.println(lista);

        System.out.println("\n======\n");

        lista.removeIf(nome -> nome.toLowerCase().startsWith("a"));
        System.out.println(lista);
    }

    public static void main(String[] args){
        listaDeNomes();
    }
}