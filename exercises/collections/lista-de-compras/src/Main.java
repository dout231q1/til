import java.util.*;

public class Main{
    static void listaDeCompras(){
        List<String> lista = new ArrayList<>();
        lista.add("Arroz");
        lista.add("Feijao");
        lista.add("Macarrao");
        lista.add("Leite");
        lista.add("Pao");
        lista.sort(Comparator.naturalOrder());
        lista.forEach(System.out::println);

    }

    public static void main(String[] args){
        listaDeCompras();
    }
}