import java.util.List;

public class Utils {

    // wildcard <?> permite aceitar List de qualquer tipo (List<String>, List<Integer>, etc.)
    // util quando nao precisamos usar o tipo T dentro do metodo, só iterar
    public static void imprimirLista(List<?> lista) {
        for (Object item : lista) {
            System.out.print(item + " ");
        }
    }

    // metodo generico com T declarado no proprio metodo (nao na classe)
    // T e inferido pelo compilador com base no tipo do array passado
    // retorna o elemento do array no indice informado com o tipo correto
    public static <T> T pegar(T[] array, int index) {
        return array[index];
    }
}