import java.util.*;
import java.util.stream.Collectors;

public class Main{
    public static void main(String[] args) {
        List<String> nomes = List.of(
                "Fernanda Keeper", "Fernanda Santos",
                "Eduardo Moreira", "Ariel Souza"
        );

        // anyMatch — retorna true se pelo menos um elemento bater com a condicao
        boolean confereNomePorLetraEspecifica = nomes.stream()
                .anyMatch(n -> n.startsWith("F"));

        System.out.println(confereNomePorLetraEspecifica); // true

        // allMatch — retorna true somente se todos os elementos baterem com a condicao
        boolean confereNomesPorLetraEspecifica = nomes.stream()
                .allMatch(n -> n.startsWith("F"));

        System.out.println(confereNomesPorLetraEspecifica); // false — Eduardo e Ariel nao comecam com F

        List<Integer> numeros = List.of(
                1,2,3,4,5,6,7,8,9,10
        );

        // .stream() abre a esteira — transforma a lista numa sequencia de elementos para processar
        int soma = numeros.stream()
                .filter(n -> n % 2 == 1) // filtra so os impares
                .reduce(0, (acc, n) -> acc + n); // reduz dois elementos em um via BinaryOperator
        // identity e o comeco, acc guarda o resultado anterior, n e o proximo elemento
        //        acc=0,  n=1 res=1
        //        acc=1,  n=3 res=4
        //        acc=4,  n=5 res=9
        //        acc=9,  n=7 res=16
        //        acc=16, n=9 res=25
        System.out.println(soma); // 25

        List<String> palavras = List.of("aviao", "pao", "vo", "magna");
        System.out.println(palavras);

        // map — transforma cada elemento da esteira em outro valor
        // aqui corrige a acentuacao via switch e coloca a primeira letra em maiusculo
        List<String> corrigidas = palavras.stream()
                .map(palavra -> {
                    String corrigida = switch (palavra) {
                        case "aviao" -> "avião";
                        case "pao"   -> "pão";
                        case "vo"    -> "vô";
                        default      -> palavra;
                    };
                    return Character.toUpperCase(corrigida.charAt(0)) + corrigida.substring(1);
                })
                .collect(Collectors.toList()); // termina a esteira e coleta o resultado numa lista

        System.out.println(corrigidas);

        List<String> nomesBaguncados = List.of(
                "Bruno", "Felipe", "Jose",
                "Tulio", "Roberta", "Flavio",
                "Arthur", "Ruan", "Claudio",
                "Tulio"
        );
        System.out.println(nomesBaguncados); // antes


        List<String> nomesOrdenados = nomesBaguncados.stream()
                .distinct() // distinct — remove duplicatas
                .sorted() // Comparator.reverseOrder() pra inverter a ordem, mas por default e alfabeticamente
                .collect(Collectors.toList());

        System.out.println(nomesOrdenados); // depois

        List<Integer> dezNumeros = List.of(
                1,2,3,4,5,6,7,8,9,10,
                11,12,13,14,15,16,17,18,19,20
        );

        System.out.println(dezNumeros.stream().count()); // count — retorna quantos elementos tem na esteira

        // limit — corta a esteira nos primeiros n elementos
        System.out.println(dezNumeros.stream()
                .limit(10)
                .collect(Collectors.toList()));
    }
}