import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // criando instancias genericas de CoisaPraPrintar com tipos diferentes
        CoisaPraPrintar<Integer> c = new CoisaPraPrintar<>(10);
//        CoisaPraPrintar<String> c2 = new CoisaPraPrintar<>("Eae"); // String nao e permitida pois T extends Number
        CoisaPraPrintar<Double> c3 = new CoisaPraPrintar<>(20.090000);

//        c.print();
//        c2.print();

        // sem bound precisaria fazer cast manual para operar
        // com bound, o Java faz unboxing e promocao numerica automaticamente (Integer + Double = Double)
        System.out.println(c.coisaPraPrintar + c3.coisaPraPrintar); // 30.09

        // nao compilaria: nao da pra somar Integer com String
//        System.out.println((Integer) c.coisaPraPrintar + (String) c2.coisaPraPrintar);

        // calculadora generica limitada a Number — aqui usada com Integer
        Calculadora<Integer> calc = new Calculadora<>();
        calc.valor = 10;
        System.out.println(calc.valor + 10); // 20

        // Comparavel usa Comparable<T>, entao comparar() delega ao compareTo() do proprio tipo
        Comparavel<Integer> com = new Comparavel<>();
        System.out.println(com.comparar(2, 3)); // -1 (2 e menor que 3)

        // Par com dois tipos diferentes: A = String (livre), B = Integer (extends Number)
        Par<String, Integer> pares = new Par<>("idade", 25);

        // eNumeroPar() usa intValue() de Number para verificar paridade
        System.out.println(pares.primeiro + ": " + pares.segundo + "\nA idade e par? " + pares.eNumeroPar());

        // wildcard <?> em imprimirLista aceita List de qualquer tipo
        List<String> lista = new ArrayList<>();
        lista.add("Ola");
        lista.add("Oi");
        lista.add("Eae");

        Utils.imprimirLista(lista);

        System.out.println("\n");

        // pegar() e um metodo generico que infere T a partir do array passado — aqui T = String
        String[] letras = {"a", "b", "c", "d", "e", "f"};

        for (int i = 0; i < letras.length; i++) {
            System.out.println(i + ": " + Utils.pegar(letras, i));
        }

        System.out.println(Utils.pegar(letras, 3)); // "d"
    }
}