import java.util.*;

public class Main {
    public static void main(String[] args) {

        // List interface e uma lista ordenada que permite duplicatas
        // para criar listas mutavel, se usa new ArrayList ou new LinkedList
        List<String> listExemplo = List.of("a", "b", "a", "c");
        System.out.println(listExemplo); // output a, b, a, c

        // Set interface e uma lista nao ordenada que nao permite duplicatas
        // instanciando HashSet e criando uma lista mutavel, ele apenas remove as duplicatas ignorando elas
        Set<String> setExemplo = new HashSet<>(listExemplo);
        System.out.println(setExemplo); // output pode variar pois HashSet nao garante ordem

        // usando Set.of estoura um erro no runtime, onde a jvm reclama que tem duplicata
        Set<String> setExemplo2 = Set.of("a", "b", "c");

        Map<String, String> mapExemplo = new HashMap<>();
        mapExemplo.put("Fernanda", "Kipper");
        mapExemplo.put("Christopher", "Nolan");
        mapExemplo.put("Bryan", "Cranston");

        // em Map pegamos o value usando a key
        System.out.println(mapExemplo.get("Bryan"));
        System.out.println(mapExemplo.keySet()); // retorna todas as keys
        System.out.println(mapExemplo.values()); // retorna todos os values
        Set<Map.Entry<String, String>> keysValues = mapExemplo.entrySet();
        System.out.println(keysValues); // output [Bryan=Cranston, Christopher=Nolan, Fernanda=Kipper]
        // para podermos manipular os dados usamos um for
        for (Map.Entry<String, String> entry : keysValues) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        Queue<String> queueExemplo = new LinkedList<>();
        queueExemplo.offer("Fernanda");
        queueExemplo.offer("Christopher");
        queueExemplo.offer("Bryan");
        System.out.println(queueExemplo); // output: [Fernanda, Christopher, Bryan]
        System.out.println(queueExemplo.peek()); // apenas retorna o primeiro da fila mas nao remove
        System.out.println(queueExemplo); // output: [Fernanda, Christopher, Bryan]
        System.out.println(queueExemplo.poll()); // retorna o primeiro da fila porem remove, retorna null caso a fila esteja vazia
        System.out.println(queueExemplo); // output: [Christopher, Bryan]
        System.out.println(queueExemplo.remove()); // mesma coisa do metodo poll porem ele lanca excessao caso a fila esteja vazia
        System.out.println(queueExemplo); // output: [Bryan]

    }
}