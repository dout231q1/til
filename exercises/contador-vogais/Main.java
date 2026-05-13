import java.util.List;

public class Main{
    static void contadorDeVogais(){
        int contador = 0;
        List<Character> vogais = List.of('a','e','i','o','u');
        String palavra = "narwhals narwhals swimming in the ocean causing a commotion coz they are so awesome";
        for(char letra : palavra.toCharArray()){
            if (vogais.contains(letra)){
                contador ++;
            }
        }
        System.out.println("Totais de vogais encontradas: " + contador);
    }

    public static void main (String[] args){
        contadorDeVogais();
    }
}