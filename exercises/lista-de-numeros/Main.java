import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main{
    static void listaDeNumeros(){
        List<Integer> lista = new ArrayList<>();
        for(int quantidade = 0; quantidade <= 10; quantidade++){
            lista.add(quantidade);
        }
        String resultado =  lista.stream()
                .filter(numero -> numero % 2 == 0)
                .map(String::valueOf) // converte em string
                .collect(Collectors.joining(" -> ")); // junta com " -> "
        System.out.println(resultado);
    }

    public static void main(String[] args){
        listaDeNumeros(); // output: 2 -> 4 -> 6 -> 8 -> 10
    }
}