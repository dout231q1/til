// T extends Comparable<T> garante que o tipo passado implementa compareTo()
// isso permite comparar dois valores de forma genérica e type-safe
public class Comparavel<T extends Comparable<T>> {

    // delega a comparação ao próprio metodo compareTo() do tipo T
    // retorna: negativo se valor < outro, 0 se igual, positivo se maior
    int comparar(T valor, T outro) {
        return valor.compareTo(outro);
    }
}