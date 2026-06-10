import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<String> nomes = new ArrayList<>(
                Arrays.asList("Ana", "Pedro", "Li", "Carlos", "Jo")
        );

        Collections.sort(nomes, new Comparator<String>(){ // pode ser simplificado para lambda, mas manteremos como classe anonima para praticar
                @Override
                public int compare(String a, String b){
                    int diff = a.length() - b.length();
                    return diff != 0 ? diff : a.compareTo(b); // ? = if, : = else
                }
        });

        System.out.println(nomes); // output: Jo, Li, Ana, Pedro, Carlos
    }
}