import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main{
    static void listaUnica(){
        List<Integer> listaUm = new ArrayList<>();
        listaUm.add(13);
        listaUm.add(48);
        listaUm.add(52);
        listaUm.add(17); // duplicada
        listaUm.add(23); // duplicada

        System.out.println("Lista um:");
        System.out.println(listaUm);


        List<Integer> listaDois = new ArrayList<>();
        listaDois.add(23); // duplicada
        listaDois.add(49);
        listaDois.add(64);
        listaDois.add(17); // duplicada
        listaDois.add(2);
        listaDois.add(24);

        System.out.println("Lista dois:");
        System.out.println(listaDois);

        List<Integer> listaUnica = Stream.concat(listaUm.stream(), listaDois.stream())
                .distinct()
                .collect(Collectors.toList());

        System.out.println("Lista sem repeticoes:");
        System.out.println(listaUnica);
    }

    public static void main(String[] args){
        listaUnica();
    }
}