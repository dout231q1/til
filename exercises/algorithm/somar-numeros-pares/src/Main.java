import java.util.List;

public class Main {
    static void somarPares(){
        int soma = 0;
        List<Integer> numeros = List.of(1,2,3,4,5,6,7,8,9,10);
        for(int numero : numeros){
            if(numero % 2 == 0){
                final int somaAnterior = soma;
                soma += numero;
                System.out.printf("Numero: %d, Soma: %d + %d = %d%n", numero, numero, somaAnterior, soma);
            }
        }


    }

    public static void main(String[] args){
        somarPares();
    }
}