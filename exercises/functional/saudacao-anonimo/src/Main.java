import java.lang.reflect.Array;
import java.util.*;

public class Main {

    interface Validador<T>{
        boolean validar(T valor);
    }

    static <T>Validador<T> combinar(Validador<T> v1, Validador<T> v2) {
        return new Validador<T>() {
            @Override
            public boolean validar(T valor) {
                return false;
            }
        };
    }

    // Functional interfaces
    // Runnable, Predicate, Function, Consumer, Supplier

    static Runnable criarTarefas(String nome, int repeticoes){
        return new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < repeticoes; i++){
                    System.out.println(nome);
                }
            }
        };
    }

    public static void main(String[] args) {
        Validador<String> naoVazia = Validador;
        Validador<String> minimo5  = /* classe anônima */;
        Validador<String> ambos    = combinar(naoVazia, minimo5);
        Saudacao s = new Saudacao(){
            public void saudar(){
                System.out.println("Saudar");
            }
            public void darTchau(){
                System.out.println("Tchauuuu");
            }
        };
        s.saudar();
        s.darTchau();
//
//        Saudacao2 s2 = new Saudacao2(){
//          public void saudar(){
//              System.out.println("Saudar");
//          }
//        };
//        s2.saudar();

//        Operacao o = new Operacao() {
//            public void calcularSoma(int a, int b){
//                System.out.println(a + b);
//            }
//            public void calcularSub(int a, int b){
//                System.out.println(a - b);
//            }
//            public void calcularMult(int a, int b){
//                System.out.println(a * b);
//            }
//        };
//        o.calcularSoma(10, 3);
//        o.calcularSub(10, 3);
//        o.calcularMult(10, 3);


        List<Integer> numeros = new ArrayList<>(
                Arrays.asList(38, 27, 43, 3, 9, 82, 10, 99, 10, 3, 38)
        );

        Collections.sort(numeros);

        System.out.println(numeros);


        List<String> nomes = new ArrayList<>(
                Arrays.asList("Ana", "Pedro", "Li", "Carlos", "Jo")
        );

        Collections.sort(nomes, new Comparator<String>() {
            @Override
            public int compare(String a, String b){
                int diff = a.length() - b.length();
                return diff !=0 ? diff : a.compareTo(b);
            }
        });

        System.out.println(nomes);

        Runnable r = criarTarefas("Java", 3);
        r.run();

    }
}