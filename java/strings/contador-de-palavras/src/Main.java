import java.util.*;

public class Main{
    public static void main(String[] args) {

        // Contador de palavras

        String texto = "o gato e o cachorro corriam pelo jardim enquanto o gato subia na arvore e o cachorro latia para o gato que estava no alto da arvore o passaro voou do jardim para a arvore e ficou perto do gato que observava o cachorro latir o dono do cachorro chamou o cachorro mas o cachorro nao parou de latir para o gato e o gato continuou na arvore ignorando o cachorro e o passaro que voou de volta para o jardim onde o dono esperava o cachorro voltar para casa";

        Map<String, Integer> contador = new HashMap<>();
        // map contador para guardar as palavras e a quantidade repetida na string texto

        System.out.println(texto); // printa o texto sem nenhuma alteracao

        String[] textoArray = texto.split(" "); // quebra o texto em diversas substrings a cada espaco branco
        for(String palavra : textoArray){
            if(contador.containsKey(palavra)){
                contador.put(palavra, contador.get(palavra) + 1);
                // adiciona na key (palavra) o nome da palavra e +1 na quantidade, se ela cair na condicao do if, que e caso foi repetida
            } else {
                contador.put(palavra, 1);
                // se a key (palavra) nao foi repetida uma vez ela cai na condicao do else, que e caso ela seja nova adicionando apenas o nome da palavra e 1 no value (quantidade)
            }
        }
        contador.entrySet()
                    .stream()
                    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                    .forEach(entrada -> System.out.println(entrada.getKey() + ": " + entrada.getValue()));
            // for para printar as key e value do map por ordem decrescente do value
    }
}