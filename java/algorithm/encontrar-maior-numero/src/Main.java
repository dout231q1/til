import java.util.List;

public class Main{
    static void encontrarMaiorNumero() {
            int maiorNumero = 0;
            List<Integer> numeros = List.of(15, 8, 23, 4, 42, 16);
            for (int numero : numeros) {
                if (numero > maiorNumero) {
                    maiorNumero = numero;
                }
//            System.out.printf("O maior numero agora e: %d %n",maiorNumero);
            }
            System.out.println(maiorNumero);
        }
    public static void main(String[] args) {
        encontrarMaiorNumero();
    }
}