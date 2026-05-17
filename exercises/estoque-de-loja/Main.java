import java.util.HashMap;

public class Main{
    public static void main(String[] args){
        HashMap<String, Integer> estoqueProdutos = new HashMap<>();

                    // nome | quantidade
        estoqueProdutos.put("Banana", 5);
        estoqueProdutos.put("Maca", 3);
        estoqueProdutos.put("Uva", 30);
        estoqueProdutos.put("Morango", 6);
        estoqueProdutos.put("Melancia", 1);

        System.out.println(estoqueProdutos);

        estoqueProdutos.replace("Banana", 2); // troca quantidade da banana, porque a key 'banana' existe
        System.out.println(estoqueProdutos);
        
        estoqueProdutos.replace("Kiwi", 2); // nao troca quantidade da banana, porque a key 'kiwi' nao existe
        System.out.println(estoqueProdutos);

        estoqueProdutos.putIfAbsent("Kiwi", 2); // insere kiwi na lista, porque a key 'kiwi' nao existe ainda
        System.out.println(estoqueProdutos);

        estoqueProdutos.putIfAbsent("Uva", 2); // nao muda quantidade da uva na lista, porque a key 'uva' ja existe
        System.out.println(estoqueProdutos);
    }
}